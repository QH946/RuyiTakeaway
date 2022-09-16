package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 菜品管理 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface DishService extends IService<Dish> {

    /**
     * 新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
     * @param dishDto
     */
     void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
     DishDto getByIdWithFlavor(Long id);

    /**
     * 更新菜品信息，同时更新对应的口味信息
     * @param dishDto
     */
     void updateWithFlavor(DishDto dishDto);
}
