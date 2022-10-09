package com.qh.ruyitakeaway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详细dto
 *
 * @author qh
 * @date 2022/10/09 11:37:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDto {

    private String name;
    private Integer number;

}
