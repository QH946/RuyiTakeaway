package com.qh.ruyitakeaway.controller;


import com.qh.ruyitakeaway.common.R;
import com.qh.ruyitakeaway.entity.ShoppingCart;
import com.qh.ruyitakeaway.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Api(tags = "购物车管理")
@Slf4j
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     *
     * @param shoppingCart
     * @return
     */
    @ApiOperation("添加购物车数据")
    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart) {
        log.info("购物车数据:{}", shoppingCart);
        ShoppingCart cartServiceOne = shoppingCartService.addShoppingChart(shoppingCart);
        return R.success(cartServiceOne);
    }

    /**
     * 查看购物车
     *
     * @return
     */
    @ApiOperation("获取购物车列表")
    @GetMapping("/list")
    public R<List<ShoppingCart>> list() {
        log.info("查看购物车...");
        List<ShoppingCart> list = shoppingCartService.getList();
        return R.success(list);
    }

    /**
     * 减少购物车中的菜品
     *
     * @param shoppingCart
     * @return
     */
    @ApiOperation("减少购物车中菜品")
    @PostMapping("/sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart) {
        ShoppingCart sc = shoppingCartService.reduceDish(shoppingCart);
        return R.success(sc);
    }

    /**
     * 清空购物车
     *
     * @return
     */
    @ApiOperation("清空购物车")
    @DeleteMapping("/clean")
    public R<String> clean() {
        //SQL:delete from shopping_cart where user_id = ?
        shoppingCartService.cleanAll();
        return R.success("清空购物车成功");
    }
}

