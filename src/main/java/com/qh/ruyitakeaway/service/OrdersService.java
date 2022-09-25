package com.qh.ruyitakeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);

    /**
     * 后台订单分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @return {@link Page}
     */
    Page getPage(int page, int pageSize);

    /**
     * 再来一单
     *
     * @param order1 order1
     */
    void againList(Orders order1);

    /**
     * 后台查看订单明细
     *
     * @param page      页面
     * @param pageSize  页面大小
     * @param number    数量
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return {@link Page}
     */
    Page getListDetails(int page, int pageSize, String number, String beginTime, String endTime);

    /**
     * 外卖订单派送
     *
     * @param orders 订单
     */
    void send(Orders orders);
}
