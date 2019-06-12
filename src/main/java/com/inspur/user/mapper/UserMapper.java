package com.inspur.user.mapper;

import com.inspur.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * User: YANG
 * Date: 2019/6/13-3:11
 * Description: No Description
 */
//@Mapper 这里不用了 在App中添加 @MapperScan 就OK了
public interface UserMapper {

    @Select("select * from user u where u.username = #{username}")
    public User getUserByUserName(@Param("username") String username);

    @Insert("insert into user (username, age) values (#{username}, #{age})")
    public int insertUser(@Param("username") String username, @Param("age") Integer age);
}
