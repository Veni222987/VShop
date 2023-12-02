package tech.veni.vshop.service;

import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.vo.Res2Cart;
import tech.veni.vshop.vo.Res2Order;

import java.util.List;

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

    /**
     * 结算，将购物车清空加入购物历史
     *
     * @param uid
     * @param oid
     * @return
     */
    String pay(String uid, String oid);

    /**
     * 查询某人的购物历史
     *
     * @param uid
     * @return
     */
    List<ConsumeHistory> listConsumeHistory(String uid);

    /**
     * 查询某人的订单
     *
     * @param uid
     * @return
     */
    List<Order> listOrder(String uid);
}
