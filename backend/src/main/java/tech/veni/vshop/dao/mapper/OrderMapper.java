package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.*;
import tech.veni.vshop.dao.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO `order` (`oid`, `uid`, `item_id`, `sum`,`count`,`recipient`,`address`,`phone_number`, `create_time`)"
            + " VALUES (#{order.oid}, #{order.uid}, #{order.itemId}, #{order.sum}, #{order.count}, #{order.recipient}, #{order.address}, #{order.phoneNumber}, #{order.createTime})")
    void insert(@Param("order") Order order);

    @Select("SELECT * FROM `order` WHERE `oid` = #{oid}")
    List<Order> selectByOid(@Param("oid") String oid);

    @Delete("DELETE FROM `order` WHERE `oid` = #{oid}")
    Integer deleteByOid(@Param("oid") String oid);

    @Select("SELECT * FROM `order` WHERE `uid` = #{uid}")
    List<Order> selectByUid(@Param("uid") String uid);
}
