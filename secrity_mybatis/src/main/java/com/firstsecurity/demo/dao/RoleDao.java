package com.firstsecurity.demo.dao;


import com.firstsecurity.demo.bean.Role;
import com.firstsecurity.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Results( id="userMap", value = {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "role", property = "role" , javaType = String.class)
    })
    @Select(value=" SELECT sr.id, sr.role "+
            "FROM s_role sr " +
            "LEFT JOIN s_user_role sur ON sr.id = sur.fk_role_id " +
            " LEFT JOIN s_user su ON sur.fk_user_id = su.id " +
            " WHERE su.id = #{userid} ")
    List<Role> listRoleByUserId(@Param("userid") int id);
}

