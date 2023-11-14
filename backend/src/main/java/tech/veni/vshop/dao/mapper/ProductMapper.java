package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.Product;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO `product` (`id`, `name`, `cover`, `price`, `stock`, `create_time`, `update_time`)"
            + " VALUES (#{product.id}, #{product.name}, #{product.cover}, #{product.price}, #{product.stock}, #{product.createTime}, #{product.updateTime})")
    void insert(@Param("product") Product product);
}
