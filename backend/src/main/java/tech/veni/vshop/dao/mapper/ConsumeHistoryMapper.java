package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.ConsumeHistory;
import tech.veni.vshop.dao.Order;

import java.util.List;

@Mapper
public interface ConsumeHistoryMapper {

    @Insert("INSERT INTO `consume_history` (`id`, `uid`, `item_id`, `count`, `sum`, `create_time`)"
            + " VALUES (#{consumeHistory.id}, #{consumeHistory.uid}, #{consumeHistory.itemId}, #{consumeHistory.count}, #{consumeHistory.sum}, #{consumeHistory.createTime})")
    void insert(@Param("consumeHistory") ConsumeHistory consumeHistory);

    @Insert("INSERT INTO `consume_history` (`oid`, `uid`, `item_id`, `sum`,`count`,`recipient`,`address`,`phone_number`, `create_time`)"
            + " VALUES (#{orders.oid}, #{orders.uid}, #{orders.itemId}, #{orders.sum}, #{orders.count}, #{orders.recipient}, #{orders.address}, #{orders.phoneNumber}, #{orders.createTime})")
    void insertByOrders(@Param("orders") Order orders);

    @Select("SELECT * FROM `consume_history` WHERE `uid` = #{uid}")
    List<ConsumeHistory> list(@Param("uid") String uid);
}
