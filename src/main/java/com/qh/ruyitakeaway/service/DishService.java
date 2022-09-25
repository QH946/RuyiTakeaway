package com.qh.ruyitakeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.entity.Dish;

import java.util.List;


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

    /**
     * 菜品信息分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Page}
     */
    Page getPage(int page, int pageSize, String name);

    /**
     * 根据条件查询对应的菜品数据
     *
     * @param dish 菜
     * @return {@link List}<{@link DishDto}>
     */
    List<DishDto> dishDtoList(Dish dish);

    /**
     * 修改菜品售卖状态
     *
     * @param status 状态
     * @param ids    id
     * @return {@link String}
     */
    void updateSale(int status, String[] ids);

    /**
     * 删除菜品
     *
     * @param ids id
     * @return {@link Boolean}
     */
    void deleteDish(String[] ids);

}
