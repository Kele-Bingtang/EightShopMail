package com.eight.controller;

import com.eight.bean.UpdateInfo;
import com.eight.service.WcyIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class WcyUserController {

    @Autowired
    private WcyIUserService wcyIUserService;


    /**
     * 个人资料页面
     * @param user_id
     * @return
     */
    @GetMapping("info")
    @ResponseBody
    public ModelAndView info(String userId){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(wcyIUserService.info(userId));
        modelAndView.addObject("userInfo",wcyIUserService.info(userId));

        modelAndView.setViewName("info.html");
        return modelAndView;
    }
    /**
     * 获取个人信息
     * @param updateInfo
     * @return个人信息
     */
    @GetMapping("/updateInfo")
    @ResponseBody
    public ModelAndView updateInfo(UpdateInfo updateInfo) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(wcyIUserService.updateInfo(updateInfo));
        modelAndView.addObject("updateInfo", wcyIUserService.updateInfo(updateInfo));
        modelAndView.setViewName("updateInfo.html");
        return modelAndView;
    }

    /**
     * 个人信息修改
     * @param updateInfo
     * @return 不返回
     */
    @GetMapping("/updateInfos")
    @ResponseBody
    public ModelAndView update(UpdateInfo updateInfo) {
        ModelAndView modelAndView = new ModelAndView();
        wcyIUserService.update(updateInfo);
        modelAndView.setViewName("updateInfo");
        return modelAndView;
    }


    /**
     * 返回个人信息页面
     */

    @GetMapping("returnPage")//这是请求的网址名称
    @ResponseBody
    public ModelAndView returnPage(String userInfoId){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(wcyIUserService.returnPage(userInfoId));
        modelAndView.addObject("userInfo",wcyIUserService.returnPage(userInfoId));
        modelAndView.setViewName("info.html");//返回的网页
        return modelAndView;
    }

}

