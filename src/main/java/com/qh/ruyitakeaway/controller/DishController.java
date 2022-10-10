package com.qh.ruyitakeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.entity.Dish;
import com.qh.ruyitakeaway.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜品管理 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api("菜品管理")
@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    /**
     * 新增菜品
     *
     * @param dishDto
     * @return
     */
    @ApiOperation(value = "新增菜品")
    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        log.info(dishDto.toString());
        dishService.saveWithFlavor(dishDto);
        return R.success("添加菜品成功");
    }

    /**
     * 分页查询菜品信息
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @ApiOperation(value = "分页查询菜品信息")
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        Page pageInfo = dishService.getPage(page, pageSize, name);
        return R.success(pageInfo);
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查询菜品的详细信息")
    @GetMapping("/{id}")
    public R<DishDto> get(@PathVariable Long id) {
        DishDto dishDto = dishService.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    /**
     * 修改菜品
     *
     * @param dishDto
     * @return
     */
    @ApiOperation(value = "更新菜品信息")
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto) {
        log.info(dishDto.toString());
        dishService.updateWithFlavor(dishDto);
        return R.success("修改菜品成功");
    }

    /**
     * 修改菜品售卖状态
     *
     * @param statusType 状态类型
     * @param ids        id
     * @return {@link R}<{@link String}>
     */
    @ApiOperation(value = "停用或者启用菜品")
    @PostMapping("/status/{statusType}")
    public R<String> sale(@PathVariable Integer statusType,
                          @RequestParam List<Long> ids) {
        dishService.updateStatus(statusType, ids);
        return R.success("修改成功");
    }

    /**
     * 删除菜品
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "删除菜品")
    @DeleteMapping
    public R<String> delete(@RequestParam("ids") List<Long> ids) {
        dishService.deleteWithFlavors(ids);
        return R.success("删除成功");
    }

    /**
     * 根据条件查询对应的菜品数据
     *
     * @param dish
     * @return
     */
    @ApiOperation("分类id查询菜品信息")
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish) {
        List<DishDto> dishDtoList = dishService.dishDtoList(dish);
        return R.success(dishDtoList);
    }
}

