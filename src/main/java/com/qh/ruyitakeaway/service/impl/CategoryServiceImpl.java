package com.qh.ruyitakeaway.service.impl;

import com.qh.ruyitakeaway.entity.Category;
import com.qh.ruyitakeaway.mapper.CategoryMapper;
import com.qh.ruyitakeaway.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
