package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.Address;

import java.util.List;

@Mapper
public interface AddressMapper {
    /**
     * 插入地址
     */
    @Insert("INSERT INTO `address` (`id`, `uid`, `address_name`, `address`, `receiver`, `phone_number`, `email`)"
            + " VALUES (#{address.id}, #{address.uid}, #{address.addressName}, #{address.address}, #{address.receiver}, #{address.phoneNumber}, #{address.email})")
    void insertAddress(@Param("address") Address address);

    /**
     * 根据id查询地址
     *
     * @param id
     */
    @Select("SELECT * FROM `address` WHERE `id` = #{id}")
    Address selectAddressById(@Param("id") Integer id);

    /**
     * 查询某个用户的所有地址
     *
     * @param uid
     */
    @Select("SELECT * FROM `address` WHERE `uid` = #{uid}")
    List<Address> selectAddressByUid(@Param("uid") String uid);
}
