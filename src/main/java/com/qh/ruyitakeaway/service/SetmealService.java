package com.qh.ruyitakeaway.service;

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
     * @param id
     * @return
     */
     SetmealDto getByIdWithDish(Long id);

    /**
     * 更新套餐信息
     * @param setmealDto
     */
     void updateWithDish(SetmealDto setmealDto);

}
