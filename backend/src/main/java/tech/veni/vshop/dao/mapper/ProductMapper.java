package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO `product` (`pid`, `title`, `cover`,`seller`,`detail_url`,`category`, `price`,`attributes` ,`create_time`, `update_time`)"
            + " VALUES (#{product.pid}, #{product.title}, #{product.cover},#{product.seller},#{product.detailUrl},#{product.category}, #{product.price},#{product.attributes}, #{product.createTime}, #{product.updateTime})")
    void insert(@Param("product") Product product);

    @Select("SELECT * FROM `product` ORDER BY `create_time` DESC")
    List<Product> listProducts();

    @Select("SELECT * FROM `product` WHERE `category` = #{category} ORDER BY `create_time` DESC")
    List<Product> listProductsByCategory(@Param("category") String category);

    @Select("SELECT * FROM `product` WHERE `pid` = #{pid}")
    Product getProductByPid(@Param("pid") String pid);
}
