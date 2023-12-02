package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

    /**
     * 插入购物车记录
     *
     * @param cart
     */
    @Insert("INSERT INTO `cart` (`id`, `uid`, `goods_id`, `count`, `sum`)"
            + " VALUES (#{cart.id}, #{cart.uid}, #{cart.goodsId}, #{cart.count}, #{cart.sum})")
    void insert(@Param("cart") Cart cart);

    /**
     * 获取某人的购物车
     *
     * @param uid
     * @return List<Cart> 购物车物品列表
     */
    @Select("SELECT * FROM `cart` WHERE `uid` = #{uid}")
    List<Cart> selectByUid(@Param("uid") String uid);

    /**
     * 删除某人购物车中的部分商品
     *
     * @param uid      用户id
     * @param goodsIds 商品id列表
     */
    @Delete("<script>" +
            "DELETE FROM `cart` WHERE `uid` = #{uid} AND `goods_id` IN " +
            "<foreach collection='goodsIds' item='goodsId' open='(' separator=',' close=')'>" +
            "#{goodsId}" +
            "</foreach>" +
            "</script>")
    void deleteCartGoods(@Param("uid") String uid, @Param("goodsIds") List<String> goodsIds);

}
