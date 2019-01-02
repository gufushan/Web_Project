package com.example.demo.mapper;

import com.example.demo.enty.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/17.
 */
@Mapper
public interface UserMapper {

    @Select("select username,password from web_user where username = #{username}")
    LoginUser findUserByName(@Param("username") String username);
//
//    @Select("select a.sdate,a.interfaces,b.plans,c.projects,d.testers from " +
//            "(select \"2018-12-07\" sdate,count(id) interfaces from TestCase where visiable = 1) a " +
//            "left join ( select \"2018-12-07\" sdate,count(id) plans  from TestPlan where visiable = 1) b on a.sdate = b.sdate  " +
//            "left join ( SELECT \"2018-12-07\" sdate,count(id) projects from ProjectGroup where visiable = 1) c on a.sdate = c.sdate " +
//            "left join ( select \"2018-12-07\" sdate,count(1) testers from TestUser ) d on a.sdate = d.sdate")
//    Map<String,Integer> getDashBoardTotalData();
}
