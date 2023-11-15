package tech.veni.vshop.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tech.veni.vshop.dao.User;

@Mapper
public interface UserMapper {

    /**
     * 插入用户
     *
     * @param user
     */
    @Insert("INSERT INTO `user` (`id`, `uid`, `username`, `password`, `avatar`, `gender`, `phone_number`, `create_time`)"
            + " VALUES (#{user.id}, #{user.uid}, #{user.username}, #{user.password}, #{user.avatar}, #{user.gender}, #{user.phoneNumber}, #{user.createTime})")
    void insert(@Param("user") User user);

    /**
     * 根据手机号查询用户
     *
     * @param phoneNumber
     * @return
     */
    @Select("SELECT * FROM `user` WHERE `phone_number` = #{phoneNumber}")
    User selectByPhoneNumber(@Param("phoneNumber") String phoneNumber);


}
