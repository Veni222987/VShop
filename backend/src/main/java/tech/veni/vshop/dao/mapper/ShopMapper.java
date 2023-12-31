package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.Shop;

@Mapper
public interface ShopMapper {

    /**
     * 插入店铺
     *
     * @param shop
     */
    @Insert("INSERT INTO `shop` (id,sid,name,email,password,create_time) "
            + " VALUES (#{shop.id}, #{shop.sid}, #{shop.name}, #{shop.email}, #{shop.password}, #{shop.createTime})")
    void insert(@Param("shop") Shop shop);

    /**
     * 根据email查询店铺
     */
    @Select("SELECT * FROM `shop` WHERE `email` = #{email}")
    Shop selectByEmail(@Param("email") String email);
}
