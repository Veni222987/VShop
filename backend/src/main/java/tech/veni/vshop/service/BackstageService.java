package tech.veni.vshop.service;


import tech.veni.vshop.dao.Goods;
import tech.veni.vshop.vo.Res2ShopData;

import java.util.List;

public interface BackstageService {
    /**
     * 添加商品
     *
     * @param goods 商品
     */
    void addGoods(Goods goods);

    /**
     * 查询该商家所有商品
     *
     * @param sid 商家id
     */
    List<Goods> listGoods(String sid);

    /**
     * 修改商品信息
     *
     * @param goods
     */
    void updateGoods(Goods goods);


    /**
     * 删除商品
     *
     * @param goodsId
     */
    void deleteGoods(String goodsId);

    /**
     * 获取商家的所有订单
     *
     * @param sid
     */
    List<Res2ShopData> listOrder(String sid);

    /**
     * 查看某一件商品的销售情况
     *
     * @param goodsId
     */
    List<Res2ShopData> listGoodsOrder(String goodsId);

}
