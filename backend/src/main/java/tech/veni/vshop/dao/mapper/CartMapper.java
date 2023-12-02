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
     * 清空购物车
     *
     * @param uid
     */
    @Delete("DELETE FROM `cart` WHERE `uid` = #{uid}")
    void deleteByUid(@Param("uid") String uid);
}
