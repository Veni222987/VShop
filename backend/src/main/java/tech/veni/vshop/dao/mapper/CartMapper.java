package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.Cart;
import tech.veni.vshop.vo.Res2Cart;

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
     * @return List<Res2Cart> 购物车物品列表
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "count", column = "count"),
            @Result(property = "sum", column = "sum"),
            @Result(property = "goods", column = "goods_id", one = @One(select = "tech.veni.vshop.dao.mapper.GoodsMapper.selectOneByGoodsId"))
    })
    @Select("SELECT * FROM `cart` WHERE `uid` = #{uid}")
    List<Res2Cart> listByUid(@Param("uid") String uid);

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
