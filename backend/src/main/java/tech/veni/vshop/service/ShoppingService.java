package tech.veni.vshop.service;

import tech.veni.vshop.dao.*;
import tech.veni.vshop.vo.Res2BrowseHistory;
import tech.veni.vshop.vo.Res2Cart;
import tech.veni.vshop.vo.Res2Goods;
import tech.veni.vshop.vo.Res2ShopData;

import java.util.List;

public interface ShoppingService {

    /**
     * 首页获取商品
     */
    List<Res2Goods> listGoodsHome(Integer page, Integer size);

    /**
     * 获取分类商品
     *
     * @param category 分类
     */
    List<Res2Goods> listGoodsCategory(String category);

    /**
     * 获取商品详情
     *
     * @param id 商品id
     */
    Goods getGoodsDetail(String id);

    /**
     * 添加商品到购物车
     *
     * @param cart 购物车
     */
    void addGoodsToCart(Cart cart);

    /**
     * 获取购物车商品
     *
     * @param uid 用户id
     */
    List<Res2Cart> listCartGoods(String uid);

    /**
     * 购物车商品结算
     *
     * @param uid      用户id
     * @param cartList 商品ids
     */
    List<ConsumeHistory> settleAndCreateOrder(String uid, List<Cart> cartList, Integer addressId);


    /**
     * 付款并发送邮件
     */
    void payAndSendEmail(List<ConsumeHistory> consumeHistoryList);

    /**
     * 添加收货地址
     *
     * @param address 收货地址
     */
    void addAddress(Address address);

    /**
     * 查询某人所有收货地址
     *
     * @param uid 用户id
     */
    List<Address> listAddress(String uid);

    /**
     * 查看消费记录
     *
     * @param uid 用户id
     */
    List<Res2ShopData> listConsumeHistory(String uid);

    /**
     * 添加浏览记录
     *
     * @param watchHistory 浏览记录
     */
    void addGoodsHistory(WatchHistory watchHistory);

    /**
     * 查看浏览记录
     *
     * @param uid 用户id
     */
    List<Res2BrowseHistory> listGoodsHistory(String uid);
}
