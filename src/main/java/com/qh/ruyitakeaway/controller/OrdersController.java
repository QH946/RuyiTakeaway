package com.qh.ruyitakeaway.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.dto.OrderDto;
import com.qh.ruyitakeaway.entity.OrderDetail;
import com.qh.ruyitakeaway.entity.Orders;
import com.qh.ruyitakeaway.service.OrderDetailService;
import com.qh.ruyitakeaway.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api("订单管理")
@Slf4j
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailService orderDetailService;
    @ApiOperation("用户下单接口")
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据:{}", orders);
        ordersService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 订单管理
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("订单分页数据查询接口")
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/userPage")
    public R<Page> userPage(int page, int pageSize) {
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);

        Page<OrderDto> ordersDtoPage = new Page<>();

        //构造条件构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        //添加排序条件
        queryWrapper.orderByDesc(Orders::getOrderTime);

        //进行分页查询
        ordersService.page(pageInfo, queryWrapper);

        //对象拷贝
        BeanUtils.copyProperties(pageInfo, ordersDtoPage, "records");
        List<Orders> records = pageInfo.getRecords();
        List<OrderDto> list = records.stream().map((item) -> {
            OrderDto orderDto = new OrderDto();
            BeanUtils.copyProperties(item, orderDto);
            Long Id = item.getId();

            //根据id查订单对象
            Orders orders = ordersService.getById(Id);
            String number = orders.getNumber();
            LambdaQueryWrapper<OrderDetail> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(OrderDetail::getOrderId, number);
            List<OrderDetail> orderDetailList = orderDetailService.list(lambdaQueryWrapper);
            int num = 0;
            for (OrderDetail l : orderDetailList) {
                num += l.getNumber().intValue();
            }
            orderDto.setSumNum(num);
            return orderDto;
        }).collect(Collectors.toList());
        ordersDtoPage.setRecords(list);

        return R.success(ordersDtoPage);
    }

    /**
     * 再来一单
     *
     * @param order1
     * @return
     */
    @ApiOperation("再来一单接口")
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/again")
    public R<String> again(@RequestBody Orders order1) {
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
        return R.success("再来一单");
    }

    /**
     * 后台查看订单明细
     *
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @ApiOperation("后台查看订单明细接口")
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);

        Page<OrderDto> orderDtoPage = new Page<>();
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

        List<OrderDto> list = records.stream().map((item) -> {
            OrderDto orderDto = new OrderDto();

            BeanUtils.copyProperties(item, orderDto);
            String name = "用户" + item.getUserId();
            orderDto.setUserName(name);
            return orderDto;
        }).collect(Collectors.toList());

        orderDtoPage.setRecords(list);
        return R.success(orderDtoPage);
    }

    /**
     * 外卖订单派送
     * @param orders
     * @return
     */
    @ApiOperation("外卖订单派送接口")
    @PutMapping
    public R<String> send(@RequestBody Orders orders){
        Long id = orders.getId();
        Integer status = orders.getStatus();
        LambdaQueryWrapper<Orders> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getId,id);
        Orders one = ordersService.getOne(queryWrapper);
        one.setStatus(status);
        ordersService.updateById(one);
        return R.success("派送成功");
    }
}

