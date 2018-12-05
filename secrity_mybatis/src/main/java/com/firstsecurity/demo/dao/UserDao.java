package com.firstsecurity.demo.dao;

import com.firstsecurity.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Results( id="userMap", value = {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "name", property = "name" , javaType = String.class),
            @Result(column = "password", property = "pwd", javaType = String.class)
    })
    @Select("select id ,name ,password from s_user where name = #{username}")
    User getUserByName(@Param("username") String username);

    @Select("select * from s_user")
    List<User> listUsers();
}
