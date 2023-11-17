package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO `product` (`id`, `name`, `cover`, `price`, `stock`, `create_time`, `update_time`)"
            + " VALUES (#{product.id}, #{product.name}, #{product.cover}, #{product.price}, #{product.stock}, #{product.createTime}, #{product.updateTime})")
    void insert(@Param("product") Product product);

    @Select("SELECT * FROM `product` ORDER BY `create_time` DESC")
    List<Product> listProducts();

    @Select("SELECT * FROM `product` WHERE `category` = #{category} ORDER BY `create_time` DESC")
    List<Product> listProductsByCategory(@Param("category") String category);

    @Select("SELECT * FROM `product` WHERE `pid` = #{pid}")
    Product getProductByPid(@Param("pid") String pid);
}
