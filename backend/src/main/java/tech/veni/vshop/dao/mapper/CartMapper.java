package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.veni.vshop.dao.Cart;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO `cart` (`id`, `uid`, `item_id`, `count`, `sum`)"
            + " VALUES (#{cart.id}, #{cart.uid}, #{cart.itemId}, #{cart.count}, #{cart.sum})")
    void insert(@Param("cart") Cart cart);
}
