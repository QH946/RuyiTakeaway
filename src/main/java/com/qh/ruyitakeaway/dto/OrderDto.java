package com.qh.ruyitakeaway.dto;

import com.qh.ruyitakeaway.entity.OrderDetail;
import com.qh.ruyitakeaway.entity.Orders;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 清欢
 * @date 2022/9/17 19:55 19:55:22
 */


@Data
public class OrderDto extends Orders {
    /**
     * 订单对应的订单明细
     */
    private List<OrderDetail> orderDetails=new ArrayList<>();
    /**
     * 订单数量
     */
    private int sumNum;
}
