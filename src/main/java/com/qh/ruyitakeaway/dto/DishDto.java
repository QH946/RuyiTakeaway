package com.qh.ruyitakeaway.dto;


import com.qh.ruyitakeaway.entity.Dish;
import com.qh.ruyitakeaway.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜品dto
 *
 * @author qh
 * @date 2022/10/09 11:36:04
 */
@Data
public class DishDto extends Dish {

    /**
     * 菜品对应的口味数据
     */
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
