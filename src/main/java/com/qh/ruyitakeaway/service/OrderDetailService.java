package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.entity.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface OrderDetailService extends IService<OrderDetail> {
    /**
     * 根据订单id查询订单详细
     *
     * @param id id
     * @return {@link List}<{@link OrderDetail}>
     */
    List<OrderDetail> findByOrderId(Long id);
}
