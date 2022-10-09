package com.qh.ruyitakeaway.dto;

import com.qh.ruyitakeaway.entity.Orders;
import lombok.Data;

import java.util.List;


/**
 * 订单dto
 *
 * @author qh
 * @date 2022/10/09 11:35:55
 */
@Data
public class OrdersDto extends Orders {
    /**
     * 订单对应的订单明细
     */
    private List<OrderDetailDto> orderDetails;

    /**
     * 菜品总数
     */
    private Integer sumNum;

}
