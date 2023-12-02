package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.ConsumeHistory;

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
     * 获取某个商家的全部订单
     *
     * @param sid
     */
    @Select("SELECT * FROM `consume_history` WHERE `sid` = #{sid}")
    List<ConsumeHistory> listBySid(@Param("sid") String sid);

    /**
     * 获取某个商品的所有订单
     *
     * @param goodsId
     */
    @Select("SELECT * FROM `consume_history` WHERE `goods_id` = #{goodsId}")
    List<ConsumeHistory> listByGoodsId(@Param("goodsId") String goodsId);
}
