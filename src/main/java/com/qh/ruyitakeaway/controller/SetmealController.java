package com.qh.ruyitakeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.dto.SetmealDto;
import com.qh.ruyitakeaway.entity.Setmeal;
import com.qh.ruyitakeaway.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 套餐 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api(tags = "套餐相关接口")
@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    /**
     * 新增套餐
     *
     * @param setmealDto
     * @return
     */
    @PostMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    @ApiOperation(value = "新增套餐接口")
    public R<String> save(@RequestBody SetmealDto setmealDto) {
        log.info("套餐信息:{}", setmealDto);
        setmealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功");
    }

    /**
     * 套餐分页查询
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "套餐分页查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true),
            @ApiImplicitParam(name = "name", value = "套餐名称", required = false)
    })
    public R<Page> page(int page, int pageSize, String name) {
        Page dtoPage = setmealService.getPage(page, pageSize, name);
        return R.success(dtoPage);
    }


    /**
     * 删除套餐
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    @ApiOperation(value = "套餐删除接口")
    public R<String> delete(@RequestParam List<Long> ids) {
        log.info("ids:{}", ids);

        setmealService.removeWithDish(ids);

        return R.success("套餐数据删除成功");
    }

    /**
     * 根据id查询套餐及对应菜品信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "套餐条件查询接口")
    public R<SetmealDto> getById(@PathVariable Long id) {
        SetmealDto setmealDto = setmealService.getByIdWithDish(id);
        return R.success(setmealDto);
    }

    /**
     * 修改套餐
     *
     * @param setmealDto
     * @return
     */
    @PutMapping
    @CacheEvict(value = "setmealCache", allEntries = true)
    @ApiOperation(value = "修改套餐查询接口")
    public R<String> update(@RequestBody SetmealDto setmealDto) {
        setmealService.updateWithDish(setmealDto);
        return R.success("修改成功");
    }

    /**
     * 修改套餐售卖状态
     *
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation(value = "修改售卖状态接口")
    public R<String> sale(@PathVariable int status, String[] ids) {
        setmealService.updateSale(status, ids);
        return R.success("修改成功");
    }

    /**
     * 根据条件查询套餐数据
     *
     * @param setmeal
     * @return
     */
    @GetMapping("/list")
    @Cacheable(value = "setmealCache", key = "#setmeal.categoryId + '_' + #setmeal.status")
    @ApiOperation(value = "根据条件查询套餐数据接口")
    public R<List<Setmeal>> list(Setmeal setmeal) {
        List<Setmeal> list = setmealService.getList(setmeal);
        return R.success(list);
    }

    /**
     * 移动端点击套餐图片查看套餐具体内容
     * 这里返回的是dto 对象，因为前端需要copies这个属性
     * 前端主要要展示的信息是:套餐中菜品的基本信息，图片，菜品描述，以及菜品的份数
     *
     * @param SetmealId
     * @return
     */
    @GetMapping("/dish/{id}")
    @ApiOperation("查看套餐信息")
    public R<List<DishDto>> dish(@PathVariable("id") Long SetmealId) {
        List<DishDto> dishDtoList = setmealService.getDishById(SetmealId);
        return R.success(dishDtoList);
    }
}


