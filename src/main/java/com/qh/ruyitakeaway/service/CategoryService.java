package com.qh.ruyitakeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qh.ruyitakeaway.entity.Category;

import java.util.List;

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

    /**
     * 分页查询套餐及菜品分类
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @return {@link Page}
     */
    Page getPage(int page, int pageSize);

    /**
     * 根据条件查询分类数据
     *
     * @param category 类别
     * @return {@link List}<{@link Category}>
     */
    List<Category> list(Category category);
}
