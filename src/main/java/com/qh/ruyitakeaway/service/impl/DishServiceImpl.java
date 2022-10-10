package com.qh.ruyitakeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qh.ruyitakeaway.common.exception.CustomException;
import com.qh.ruyitakeaway.common.utils.RedisUtils;
import com.qh.ruyitakeaway.dto.DishDto;
import com.qh.ruyitakeaway.entity.Category;
import com.qh.ruyitakeaway.entity.Dish;
import com.qh.ruyitakeaway.entity.DishFlavor;
import com.qh.ruyitakeaway.mapper.DishMapper;
import com.qh.ruyitakeaway.service.CategoryService;
import com.qh.ruyitakeaway.service.DishFlavorService;
import com.qh.ruyitakeaway.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜品管理 服务实现类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Service

public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisUtils redisUtils;
    @Value("#{new Long(${redisCache.timeOut})}")
    private Long cacheTimeOut;
    @Value("${redisCache.dishCachePrefix}")
    private String dishCachePrefix;


    /**
     * 新增菜品，同时保存对应的口味数据
     * 涉及到多表操作，开启事务管理
     *
     * @param dishDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品信息到dish
        this.save(dishDto);

        //菜品id
        Long dishId = dishDto.getId();
        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors.stream().map((dishFlavor) -> {
            dishFlavor.setDishId(dishId);
            return dishFlavor;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);

        //删除缓存
        redisUtils.deleteObject(dishCachePrefix + dishDto.getCategoryId());
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品基本信息，从dish表查询
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);

        //查询当前菜品对应的口味信息，从dish_flavor表查询
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);
        return dishDto;
    }

    /**
     * 修改菜品
     *
     * @param dishDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWithFlavor(DishDto dishDto) {
        //更新dish表基本信息
        this.updateById(dishDto);

        //清理当前菜品对应口味数据---dish_flavor表的delete操作
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        //添加当前提交过来的口味数据---dish_flavor表的insert操作
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);

        //删除缓存
        redisUtils.deleteObject(dishCachePrefix + dishDto.getCategoryId());
    }

    /**
     * 菜品信息分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @return {@link Page}
     */
    @Override
    public Page getPage(int page, int pageSize, String name) {
        //构造分页构造器对象
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        //条件构造器
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(name != null, Dish::getName, name)
                //添加排序条件
                .orderByDesc(Dish::getUpdateTime);
        //执行分页查询
        dishService.page(pageInfo, queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        List<Dish> records = pageInfo.getRecords();
        List<DishDto> list = records.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            //分类id
            Long categoryId = item.getCategoryId();
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(list);
        return dishDtoPage;
    }

    /**
     * 修改菜品售卖状态
     *
     * @param statusType 状态类型
     * @param ids        id
     */
    @Override
    public void updateStatus(Integer statusType, List<Long> ids) {
        if (!Arrays.asList(1, 0).contains(statusType)) {
            throw new CustomException("错误的请求");
        }

        // 删除缓存
        dishService.listByIds(ids)
                .stream()
                .forEach(item -> {
            redisUtils.deleteObject(dishCachePrefix + item.getCategoryId());
        });

        LambdaUpdateWrapper<Dish> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.in(Dish::getId, ids)
                .set(Dish::getStatus, statusType);
        dishService.update(updateWrapper);
    }

    /**
     * 删除菜品
     *
     * @param id id
     */
    @Override
    public void deleteWithFlavor(Long id) {
        //删除缓存
        redisUtils.deleteObject(dishCachePrefix + this.getById(id).getCategoryId());
        // 删除菜品数据
        this.removeById(id);
        // 删除对于的口味数据
        LambdaUpdateWrapper<DishFlavor> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(DishFlavor::getDishId, id);
        dishFlavorService.remove(wrapper);
    }

    /**
     * 批量删除菜品
     *
     * @param ids id
     */
    @Override
    public void deleteWithFlavors(List<Long> ids) {
        ids.stream().forEach(this::deleteWithFlavor);
    }

    /**
     * 根据条件查询对应的菜品数据
     *
     * @param dish 菜
     * @return {@link List}<{@link DishDto}>
     */
    @Override
    public List<DishDto> dishDtoList(Dish dish) {
        List<DishDto> dishDtoList = null;
        String key = dishCachePrefix + dish.getCategoryId();
        //先从dish中获取缓存数据
        dishDtoList = (List<DishDto>) redisUtils.getCacheObject(key);
        if (dishDtoList != null) {
            //如果存在直接返回，无需查询数据库
            return dishDtoList;
        }

        //构造查询条件
        LambdaQueryWrapper<Dish> wrapper = new LambdaQueryWrapper<>();
        //添加条件，查询状态为1的（起售状态）
        wrapper.eq(Dish::getStatus, 1)
                .eq(dish.getCategoryId() != null, Dish::getCategoryId, dish.getCategoryId())
                //条件排序条件
                .orderByAsc(Dish::getSort)
                .orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list(wrapper);

        dishDtoList = list.stream().map((item) -> {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item, dishDto);
            Long categoryId = item.getCategoryId();
            //根据id查分类对象
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            //当前菜品id
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(DishFlavor::getDishId, dishId);
            //SQL: select* from dishflavor where dish_id=?;
            List<DishFlavor> dishFlavorlist = dishFlavorService.list(queryWrapper);
            dishDto.setFlavors(dishFlavorlist);
            return dishDto;
        }).collect(Collectors.toList());

        //如果不存在，需要查询数据库，将查询到的菜品数据缓存到Redis
        if (!ObjectUtils.isEmpty(dishDtoList)) {
            redisUtils.setWithExpir(key, dishDtoList, cacheTimeOut);
        }
        return dishDtoList;
    }

}
