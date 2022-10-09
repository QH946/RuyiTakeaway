package com.qh.ruyitakeaway.dto;


import com.qh.ruyitakeaway.entity.Setmeal;
import com.qh.ruyitakeaway.entity.SetmealDish;
import lombok.Data;
import java.util.List;

/**
 * 套餐dto
 *
 * @author qh
 * @date 2022/10/09 11:35:44
 */
@Data
public class SetmealDto extends Setmeal {
    /**
     * 套餐对应的菜品
     */
    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
