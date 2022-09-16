package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface CategoryService extends IService<Category> {
    /**
     * 根据id删除分类
     * @param id
     */
     void remove(Long id);
}
