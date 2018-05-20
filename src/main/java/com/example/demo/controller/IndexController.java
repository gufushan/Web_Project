package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/5/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(){
        return "dashboard1";
    }

    @RequestMapping("/hello")
    public String index(){
        System.out.println("进入IndexController");
        return "index";
    }

    @RequestMapping("/dashboard")
    public String index1(){
        System.out.println("fan index");
        return "dashboard1";
    }
}
