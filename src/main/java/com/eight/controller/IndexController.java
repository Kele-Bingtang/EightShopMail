package com.eight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
public class IndexController {

    @RequestMapping("index")
    private String indexUI(){
        return "index";
    }

    @RequestMapping("loginUser")
    private String loginUser(){
        return "webpage/userLoginAndReg/loginUser";
    }

    @RequestMapping("loginPhone")
    private String loginPhone(){
        return "webpage/userLoginAndReg/loginPhone";
    }

    @RequestMapping("registerUser")
    private String registerUser(){
        return "webpage/userLoginAndReg/registerUser";
    }

    @RequestMapping("registerPhone")
    private String registerPhone(){
        return "webpage/userLoginAndReg/registerPhone";
    }

    @RequestMapping("UserOrder")
    private String UserOrder(){
        return "webpage/userLoginAndReg/registerUser";
    }


}
