package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.dao.UserDao;
import com.example.demo.enty.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/5/17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public LoginUser userLoginValid(LoginUser user) {
        if (user.username != null && !"".equals(user.getUsername())){
            LoginUser userByName = userDao.findUserByName(user.username);
            if (userByName !=null && userByName.getPassword().equals(user.getPassword())){
                return userByName;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
