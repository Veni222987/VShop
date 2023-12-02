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
    @Insert("INSERT INTO `user` (`id`, `uid`, `username`, `email`,`password`, `avatar`, `gender`, `create_time`)"
            + " VALUES (#{user.id}, #{user.uid}, #{user.username}, #{user.email},#{user.password}, #{user.avatar}, #{user.gender},  #{user.createTime})")
    void insert(@Param("user") User user);


    /**
     * 根据email查询用户
     */
    @Select("SELECT * FROM `user` WHERE `email` = #{email}")
    User selectByEmail(@Param("email") String email);

}
