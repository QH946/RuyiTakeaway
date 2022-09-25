package com.qh.ruyitakeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.dto.SetmealDto;
import com.qh.ruyitakeaway.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐并保存套餐与菜品的关联关系
     *
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     *
     * @param ids
     */
    void removeWithDish(List<Long> ids);

    /**
     * 根据id查询套餐信息
     *
     * @param id
     * @return
     */
    SetmealDto getByIdWithDish(Long id);

    /**
     * 更新套餐信息
     *
     * @param setmealDto
     */
    void updateWithDish(SetmealDto setmealDto);

    /**
     * 套餐分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    Page getPage(int page, int pageSize, String name);

    /**
     * 修改套餐售卖状态
     *
     * @param status 状态
     * @param ids    id
     * @return {@link String}
     */
    void updateSale(int status, String[] ids);

    /**
     * 得根据条件查询套餐数据
     *
     * @param setmeal setmeal
     * @return {@link List}<{@link Setmeal}>
     */
    List<Setmeal> getList(Setmeal setmeal);

    /**
     * 移动端点击套餐图片查看套餐具体内容
     *
     * @param setmealId setmeal id
     * @return {@link List}<{@link DishDto}>
     */
    List<DishDto> getDishById(Long setmealId);
}
