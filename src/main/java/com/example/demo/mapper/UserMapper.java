package com.example.demo.mapper;

import com.example.demo.enty.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/5/17.
 */
@Mapper
public interface UserMapper {

    @Select("select username,password from web_user where username = #{username}")
    LoginUser findUserByName(@Param("username") String username);


}
