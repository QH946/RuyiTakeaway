package com.qh.ruyitakeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.Category;
import com.qh.ruyitakeaway.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author QH
 * @since 2022-09-08
 */

/**
 * 分类管理
 */
@Api("分类管理")
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param category
     * @return
     */
    @ApiOperation(value = "新增分类接口")
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info("category:{}", category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询套餐及菜品分类
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取分类分页数据接口")
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        Page pageInfo = categoryService.getPage(page, pageSize);
        return R.success(pageInfo);
    }

    /**
     * 根据id删除分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除分类接口")
    @DeleteMapping
    public R<String> delete(@RequestParam("ids") Long id) {
        log.info("删除分类，id为：{}", id);

        categoryService.remove(id);

        return R.success("分类信息删除成功");
    }

    /**
     * 根据id修改分类信息
     *
     * @param category
     * @return
     */
    @ApiOperation(value = "修改分类接口")
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info("修改分类信息：{}", category);

        categoryService.updateById(category);

        return R.success("修改分类信息成功");
    }

    /**
     * 根据条件查询分类数据
     *
     * @param category
     * @return
     */
    @ApiOperation(value = "查询分类数据接口")
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        List<Category> list = categoryService.list(category);
        return R.success(list);
    }
}

