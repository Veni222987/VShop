package tech.veni.vshop.service;

import tech.veni.vshop.dao.Cart;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.dao.WatchHistory;
import tech.veni.vshop.vo.Res2Goods;

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
    Res2Goods getGoodsDetail(String id);

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
    List<Cart> listCartGoods(String uid);

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
     * 查看消费记录
     *
     * @param uid 用户id
     */
    List<ConsumeHistory> listConsumeHistory(String uid);

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
    List<WatchHistory> listGoodsHistory(String uid);
}
