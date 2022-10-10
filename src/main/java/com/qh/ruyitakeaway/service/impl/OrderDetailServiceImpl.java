package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qh.ruyitakeaway.entity.OrderDetail;
import com.qh.ruyitakeaway.mapper.OrderDetailMapper;
import com.qh.ruyitakeaway.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

    /**
     * 根据订单id查询订单详细
     *
     * @param id id
     * @return {@link List}<{@link OrderDetail}>
     */
    @Override
    public List<OrderDetail> findByOrderId(Long id) {
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId, id);
        return this.list(queryWrapper);
    }
}
