package com.eight.controller.consume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("toHtmlController")
@RequestMapping("/eight")
public class ToHtmlController {

    @RequestMapping("/index")
    private String indexUI(){
        return "index";
    }
    //
    // @RequestMapping("/loginUser")
    // private String loginUser(){
    //     return "/userLoginAndReg/loginUser";
    // }
    //
    // @RequestMapping("/loginPhone")
    // private String loginPhone(){
    //     return "/userLoginAndReg/loginPhone";
    // }
    //
    // @RequestMapping("/registerUser")
    // private String registerUser(){
    //     return "/userLoginAndReg/registerUser";
    // }
    //
    // @RequestMapping("/registerPhone")
    // private String registerPhone(){
    //     return "/userLoginAndReg/registerPhone";
    // }
    //
    // @RequestMapping("/UserOrder")
    // private String UserOrder(){
    //     return "/userLoginAndReg/registerUser";
    // }

}
