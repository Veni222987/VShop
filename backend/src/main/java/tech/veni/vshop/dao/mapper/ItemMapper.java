package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.Item;

import java.util.List;

@Mapper
public interface ItemMapper {

    @Insert("INSERT INTO `item` (`id`, `pid`, `cover`, `attributes`, `price`, `stock`, `create_time`, `update_time`)"
            + " VALUES (#{item.id}, #{item.pid}, #{item.cover}, #{item.attributes}, #{item.price}, #{item.stock}, #{item.createTime}, #{item.updateTime})")
    void insert(@Param("item") Item item);

    @Insert("<script>"
            + "INSERT INTO `item` (`id`, `pid`, `cover`, `attributes`, `price`, `stock`, `create_time`, `update_time`) VALUES "
            + "<foreach collection='items' item='item' index='index' separator=','>"
            + "(#{item.id}, #{item.pid}, #{item.cover}, #{item.attributes}, #{item.price}, #{item.stock}, #{item.createTime}, #{item.updateTime})"
            + "</foreach>"
            + "</script>")
    void insertBatch(@Param("items") List<Item> items);

    @Select("SELECT * FROM `item` WHERE `pid` = #{pid}")
    List<Item> listItemsByPid(@Param("pid") String pid);
    
}
