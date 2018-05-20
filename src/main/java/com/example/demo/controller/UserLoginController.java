package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.enty.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/17.
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user/dologin",method = RequestMethod.POST)
    public String dologin(LoginUser user, Map<String,Object> model){
        LoginUser loginUser = userService.userLoginValid(user);
        if (loginUser != null){
            model.put("message",loginUser);
            return "loginSuccess";

        }else {
            return "/index";
        }
    }


}
