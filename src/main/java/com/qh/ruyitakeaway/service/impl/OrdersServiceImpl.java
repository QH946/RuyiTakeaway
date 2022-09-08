package com.qh.ruyitakeaway.service.impl;

import com.qh.ruyitakeaway.entity.Orders;
import com.qh.ruyitakeaway.mapper.OrdersMapper;
import com.qh.ruyitakeaway.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
