package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.enty.LoginUser;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/17.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper userMapper;


    @Override
    public LoginUser findUserByName(String username) {
        return userMapper.findUserByName(username);
    }
}
