package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.vo.Res2ShopData;

import java.util.List;

@Mapper
public interface ConsumeHistoryMapper {
    /**
     * 插入消费记录
     *
     * @param consumeHistory
     */
    @Insert("INSERT INTO `consume_history` (`id`,`order_id`,`uid`, `goods_id`, `count`, `sum`, `address_id`,`create_time`)"
            + " VALUES (#{consumeHistory.id},#{consumeHistory.orderId}, #{consumeHistory.uid}, #{consumeHistory.goodsId}, #{consumeHistory.count}, #{consumeHistory.sum}, #{consumeHistory.addressId},#{consumeHistory.createTime})")
    void insert(@Param("consumeHistory") ConsumeHistory consumeHistory);

    /**
     * 获取某人的消费记录
     *
     * @param uid
     * @return
     */
    @Select("SELECT * FROM `consume_history` WHERE `uid` = #{uid}")
    List<ConsumeHistory> listByUid(@Param("uid") String uid);

    /**
     * 多表联查，根据goodsId查到sid并嵌入where条件
     *
     * @param sid
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goods", column = "goods_id", one = @One(select = "tech.veni.vshop.dao.mapper.GoodsMapper.selectOneByGoodsId")),
            @Result(property = "count", column = "count"),
            @Result(property = "sum", column = "sum"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM `consume_history` WHERE consume_history.`goods_id` IN (SELECT `goods_id` FROM `goods` WHERE `shop_id` = #{sid})")
    List<Res2ShopData> listBySid(@Param("sid") String sid);

    /**
     * 获取某个商品的所有订单
     *
     * @param goodsId
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "goods", column = "goods_id", one = @One(select = "tech.veni.vshop.dao.mapper.GoodsMapper.selectOneByGoodsId")),
            @Result(property = "count", column = "count"),
            @Result(property = "sum", column = "sum"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("SELECT * FROM `consume_history` WHERE `goods_id` = #{goodsId}")
    List<Res2ShopData> listByGoodsId(@Param("goodsId") String goodsId);
}
