package com.qh.ruyitakeaway.dto;


import com.qh.ruyitakeaway.entity.Setmeal;
import com.qh.ruyitakeaway.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
