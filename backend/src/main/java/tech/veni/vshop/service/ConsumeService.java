package tech.veni.vshop.service;

import tech.veni.vshop.vo.Res2Cart;
import tech.veni.vshop.vo.Res2Order;

public interface ConsumeService {
    /**
     * 加购物车
     *
     * @param uid 用户id
     * @param pid 商品id
     */
    void addCart(String uid, String pid, Integer count);

    /**
     * 查询某人购物车
     *
     * @param uid
     * @return List<Item> 购物车物品列表
     */
    Res2Cart listCart(String uid);

    /**
     * 购物车结算，生成订单
     *
     * @param uid
     */
    Res2Order settle(String uid);


}
