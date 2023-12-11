package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.Goods;
import tech.veni.vshop.vo.Res2Goods;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 插入单件商品
     *
     * @param goods 商品
     */
    @Insert("INSERT INTO `goods` (`id`, `goods_id`,`title`,`cover_url`,`detail_url`,`shop_id`,`category`,`price`,`stock`,`create_time`,`update_time`)"
            + " VALUES (#{goods.id}, #{goods.goodsId}, #{goods.title}, #{goods.coverUrl}, #{goods.detailUrl}, #{goods.shopId}, #{goods.category}, #{goods.price}, #{goods.stock}, #{goods.createTime}, #{goods.updateTime})")
    void insert(@Param("goods") Goods goods);

    /**
     * 修改商品信息
     *
     * @param goods
     */
    @Update("UPDATE `goods` SET `title` = #{goods.title}, `cover_url` = #{goods.coverUrl}, `detail_url` = #{goods.detailUrl}, `category` = #{goods.category}, `price` = #{goods.price}, `stock` = #{goods.stock}, `update_time` = #{goods.updateTime} WHERE `goods_id` = #{goods.goodsId}")
    void update(@Param("goods") Goods goods);

    /**
     * 删除商品
     *
     * @param goodsId
     */
    @Delete("DELETE FROM `goods` WHERE `goods_id` = #{goodsId}")
    void delete(@Param("goodsId") String goodsId);

    /**
     * 查询商家的商品
     *
     * @param sid 商家id
     */
    @Select("SELECT * FROM `goods` WHERE `shop_id` = #{sid}")
    List<Goods> selectBySid(@Param("sid") String sid);

    /**
     * 根据id查询商品
     *
     * @param goods_id 商品id
     */
    @Select("SELECT * FROM `goods` WHERE `goods_id` = #{goods_id}")
    Goods selectOneByGoodsId(@Param("goods_id") String goods_id);

    /**
     * 分页查询最新商品
     *
     * @param offset 偏移量
     * @param size   每页大小
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "coverUrl", column = "cover_url"),
            @Result(property = "detailUrl", column = "detail_url"),
            @Result(property = "category", column = "category"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "shop.id", column = "shop_id"),
            @Result(property = "shop.sid", column = "sid"),
            @Result(property = "shop.name", column = "name"),
            @Result(property = "shop.email", column = "email"),
            @Result(property = "shop.password", column = "password"),
            @Result(property = "shop.createTime", column = "shop_create_time")
    })
    @Select("SELECT g.id, g.goods_id, g.title, g.cover_url, g.detail_url, g.category, g.price, g.stock, g.create_time, s.id AS shop_id, s.sid, s.name, s.email, s.password, s.create_time AS shop_create_time " +
            "FROM goods g " +
            "LEFT JOIN shop s ON g.shop_id = s.sid " +
            "ORDER BY g.create_time DESC " +
            "LIMIT #{size} OFFSET #{offset}")
    List<Res2Goods> selectByPage(@Param("offset") Integer offset, @Param("size") Integer size);

    /**
     * 根据分类查询商品
     *
     * @param category 分类
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "coverUrl", column = "cover_url"),
            @Result(property = "detailUrl", column = "detail_url"),
            @Result(property = "category", column = "category"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "shop.id", column = "shop_id"),
            @Result(property = "shop.sid", column = "sid"),
            @Result(property = "shop.name", column = "name"),
            @Result(property = "shop.email", column = "email"),
            @Result(property = "shop.password", column = "password"),
            @Result(property = "shop.createTime", column = "shop_create_time")
    })
    @Select("SELECT g.id, g.goods_id, g.title, g.cover_url, g.detail_url, g.category, g.price, g.stock, g.create_time, s.id AS shop_id, s.sid, s.name, s.email, s.password, s.create_time AS shop_create_time " +
            "FROM goods g " +
            "LEFT JOIN shop s ON g.shop_id = s.sid " +
            "WHERE g.category = #{category} " +
            "ORDER BY g.create_time DESC")
    List<Res2Goods> selectByCategory(@Param("category") String category);

    /**
     * 根据商品id查询商品
     *
     * @param goodsId 商品id
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "coverUrl", column = "cover_url"),
            @Result(property = "detailUrl", column = "detail_url"),
            @Result(property = "category", column = "category"),
            @Result(property = "price", column = "price"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "shop.id", column = "shop_id"),
            @Result(property = "shop.sid", column = "sid"),
            @Result(property = "shop.name", column = "name"),
            @Result(property = "shop.email", column = "email"),
            @Result(property = "shop.password", column = "password"),
            @Result(property = "shop.createTime", column = "shop_create_time")
    })
    @Select("SELECT g.id, g.goods_id, g.title, g.cover_url, g.detail_url, g.category, g.price, g.stock, g.create_time, s.id AS shop_id, s.sid, s.name, s.email, s.password, s.create_time AS shop_create_time " +
            "FROM goods g " +
            "LEFT JOIN shop s ON g.shop_id = s.sid " +
            "WHERE g.goods_id = #{goodsId}")
    Res2Goods selectByGoodsId(@Param("goodsId") String goodsId);


}
