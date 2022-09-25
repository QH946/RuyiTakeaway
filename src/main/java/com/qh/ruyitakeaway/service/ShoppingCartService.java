package com.qh.ruyitakeaway.service;

import com.qh.ruyitakeaway.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    /**
     * 添加购物车
     *
     * @param shoppingCart 购物车
     * @return {@link ShoppingCart}
     */
    ShoppingCart addShoppingChart(ShoppingCart shoppingCart);

    /**
     * 查看购物车
     *
     * @return {@link List}<{@link ShoppingCart}>
     */
    List<ShoppingCart> getList();

    /**
     * 减少菜品
     *
     * @param shoppingCart 购物车
     * @return {@link ShoppingCart}
     */
    ShoppingCart reduceDish(ShoppingCart shoppingCart);
    /**
     * 清空购物车
     */
    void cleanAll();


}
