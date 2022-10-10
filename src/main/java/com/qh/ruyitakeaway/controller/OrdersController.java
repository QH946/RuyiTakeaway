package com.qh.ruyitakeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.Orders;
import com.qh.ruyitakeaway.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api(tags = "订单管理")
@Slf4j
@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @ApiOperation("用户下单")
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据:{}", orders);
        ordersService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 后台订单分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("订单分页数据查询")
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/userPage")
    public R<Page> userPage(int page, int pageSize) throws Exception {
        Page ordersDtoPage = ordersService.getPage(page, pageSize);
        return R.success(ordersDtoPage);
    }

    /**
     * 再来一单
     *
     * @param order1
     * @return
     */
    @ApiOperation("再来一单")
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/again")
    public R<String> again(@RequestBody Orders order1) {
        ordersService.againList(order1);
        return R.success("再来一单");
    }


    /**
     * 后台查看订单明细
     *
     * @param page      页面
     * @param pageSize  页面大小
     * @param number    数量
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return {@link R}<{@link Page}>
     */
    @ApiOperation("后台查看订单明细")
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        Page orderDtoPage = ordersService.getListDetails(page, pageSize, number, beginTime, endTime);
        return R.success(orderDtoPage);
    }

    /**
     * 派送外卖订单
     *
     * @param orders
     * @return
     */
    @ApiOperation("派送外卖订单")
    @PutMapping
    public R<String> send(@RequestBody Orders orders) {
        ordersService.send(orders);
        return R.success("外卖订单派送成功");
    }
}

