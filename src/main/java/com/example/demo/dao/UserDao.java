package com.example.demo.dao;

import com.example.demo.enty.LoginUser;

/**
 * Created by Administrator on 2018/5/17.
 */
public interface UserDao {
    LoginUser findUserByName(String username);
}
