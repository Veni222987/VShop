package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.Item;

@Mapper
public interface ItemMapper {

    @Insert("INSERT INTO `item` (`id`, `pid`, `cover`, `attributes`, `price`, `stock`, `create_time`, `update_time`)"
            + " VALUES (#{item.id}, #{item.pid}, #{item.cover}, #{item.attributes}, #{item.price}, #{item.stock}, #{item.createTime}, #{item.updateTime})")
    void insert(@Param("item") Item item);
}
