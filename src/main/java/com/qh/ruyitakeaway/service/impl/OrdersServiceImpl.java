package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.common.BaseContext;
import com.qh.ruyitakeaway.common.utils.ObjectConverter;
import com.qh.ruyitakeaway.dto.OrderDetailDto;
import com.qh.ruyitakeaway.dto.OrdersDto;
import com.qh.ruyitakeaway.entity.*;
import com.qh.ruyitakeaway.common.exception.CustomException;
import com.qh.ruyitakeaway.mapper.OrdersMapper;
import com.qh.ruyitakeaway.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
@Slf4j
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserService userService;
    @Autowired
    private AddressBookService addressBookService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     *
     * @param orders
     */
    @Transactional(rollbackFor = Exception.class)
    public void submit(Orders orders) {
        //获得当前用户id
        Long userId = BaseContext.getCurrentId();

        //查询当前用户的购物车数据
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ShoppingCart::getUserId, userId);
        List<ShoppingCart> shoppingCarts = shoppingCartService.list(wrapper);

        if (shoppingCarts == null || shoppingCarts.size() == 0) {
            throw new CustomException("购物车为空，不能下单");
        }

        //查询用户数据
        User user = userService.getById(userId);

        //查询地址数据
        Long addressBookId = orders.getAddressBookId();
        AddressBook addressBook = addressBookService.getById(addressBookId);
        if (addressBook == null) {
            throw new CustomException("用户地址信息有误，不能下单");
        }
        //订单号
        long orderId = IdWorker.getId();
        //原子操作，保证多线程下操作正常
        AtomicInteger amount = new AtomicInteger(0);

        List<OrderDetail> orderDetails = shoppingCarts.stream().map((item) -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());
            amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
            return orderDetail;
        }).collect(Collectors.toList());

        orders.setId(orderId);
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        //总金额
        orders.setAmount(new BigDecimal(amount.get()));
        orders.setUserId(userId);
        orders.setNumber(String.valueOf(orderId));
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(addressBook.getPhone());
        //拼接地址
        orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));
        //向订单表插入数据，一条数据
        this.save(orders);

        //向订单明细表插入数据，多条数据
        orderDetailService.saveBatch(orderDetails);

        //清空购物车数据
        shoppingCartService.remove(wrapper);
    }

    /**
     * 后台订单分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @return {@link Page}
     */
    @Override
    public Page getPage(int page, int pageSize) throws Exception {
        Page<Orders> ordersPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Orders::getOrderTime);
        ordersService.page(ordersPage, queryWrapper);

        // 转换为DTO
        Page<OrdersDto> ordersDtoPage = new Page<>();
        BeanUtils.copyProperties(ordersPage, ordersDtoPage, "records");
        List<OrdersDto> ordersDtos = ObjectConverter.collectionBeanConverter(ordersPage.getRecords(), OrdersDto.class);

        // 查询订单详情
        for (OrdersDto item : ordersDtos) {
            List<OrderDetail> orderDetails = orderDetailService.findByOrderId(item.getId());
            List<OrderDetailDto> orderDetailDtos = ObjectConverter.collectionBeanConverter(orderDetails, OrderDetailDto.class);
            item.setOrderDetails(orderDetailDtos);
            item.setSumNum(orderDetailDtos.size());
        }
        ordersDtoPage.setRecords(ordersDtos);
        return ordersDtoPage;
    }

    /**
     * 再来一单
     *
     * @param order1 order1
     */
    @Override
    public void againList(Orders order1) {
        //取得orderId
        Long id = order1.getId();
        Orders orders = ordersService.getById(id);
        //设置订单号码
        long orderId = IdWorker.getId();
        orders.setId(orderId);
        //设置订单号码
        String number = String.valueOf(IdWorker.getId());
        orders.setNumber(number);
        //设置下单时间
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        //向订单表中插入一条数据
        ordersService.save(orders);
        //修改订单明细表
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId, id);
        List<OrderDetail> list = orderDetailService.list(queryWrapper);
        list.stream().map((item) -> {
            //订单明细表id
            long detailId = IdWorker.getId();
            //设置订单号码
            item.setOrderId(orderId);
            item.setId(detailId);
            return item;
        }).collect(Collectors.toList());

        //向订单明细表中插入多条数据
        orderDetailService.saveBatch(list);
    }

    /**
     * 查看订单详细
     *
     * @param page      页面
     * @param pageSize  页面大小
     * @param number    数量
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return {@link Page}
     */
    @Override
    public Page getListDetails(int page, int pageSize, String number, String beginTime, String endTime) {
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);

        Page<OrdersDto> orderDtoPage = new Page<>();
        //构造条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //根据number进行模糊查询
        queryWrapper.like(!StringUtils.isEmpty(number), Orders::getNumber, number);
        //根据Datetime进行时间范围查询

        if (beginTime != null && endTime != null) {
            queryWrapper.ge(Orders::getOrderTime, beginTime);
            queryWrapper.le(Orders::getOrderTime, endTime);
        }
        //添加排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);

        //进行分页查询
        ordersService.page(pageInfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, orderDtoPage, "records");

        List<Orders> records = pageInfo.getRecords();

        List<OrdersDto> list = records.stream().map((item) -> {
            OrdersDto ordersDto = new OrdersDto();

            BeanUtils.copyProperties(item, ordersDto);
            String name = "用户" + item.getUserId();
            ordersDto.setUserName(name);
            return ordersDto;
        }).collect(Collectors.toList());

        orderDtoPage.setRecords(list);
        return orderDtoPage;
    }

    /**
     * 派送订单
     *
     * @param orders 订单
     */
    @Override
    public void send(Orders orders) {
        Long id = orders.getId();
        Integer status = orders.getStatus();
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getId, id);
        Orders one = ordersService.getOne(queryWrapper);
        one.setStatus(status);
        ordersService.updateById(one);
    }
}
