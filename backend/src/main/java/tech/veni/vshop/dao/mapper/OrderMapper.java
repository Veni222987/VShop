package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.Order;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO `order` (`oid`, `uid`, `item_id`, `sum`,`count`,`recipient`,`address`,`phone_number`, `create_time`)"
            + " VALUES (#{order.oid}, #{order.uid}, #{order.itemId}, #{order.sum}, #{order.count}, #{order.recipient}, #{order.address}, #{order.phoneNumber}, #{order.createTime})")
    void insert(@Param("order") Order order);
}
