package com.eight.controller.consume;

import com.eight.bean.UserInfo;
import com.eight.service.consume.IUserInfoService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;


@Controller("userInfoController")
@RequestMapping("/eight/userInfo")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 个人资料页面
     * @return
     */
    @GetMapping("/queryUserInfo")
    public String queryUserInfo(Long userId,Model model){
        model.addAttribute("userId", userId);
        return "comsume/userInfo";
    }

    @RequestMapping("personPage")
    public String userInfoPage(Long userId,Model model){
        model.addAttribute("userInfo",userInfoService.queryAllUserInfoByUserId(userId));

        return "/comsume/personPage";
    }

    @RequestMapping("addressPage")
    public String addressPage(Long userId,Model model){
        model.addAttribute("userInfo",userInfoService.queryAllUserInfoByUserId(userId));

        return "/comsume/addressPage";
    }
    @RequestMapping("userSecurityPage")
    public String userSecurityPage(Long userId,Model model){
        model.addAttribute("userInfo",userInfoService.queryAllUserInfoByUserId(userId));

        return "/comsume/userSecurityPage";
    }


    /**
     * 个人信息修改
     * @param userInfo 用户信息
     * @return 不返回
     */
    @PostMapping("/modifyPersonInfo")
    public HashMap<String, Object> modifyPersonInfo(UserInfo userInfo, Model model) {
        int i = userInfoService.modifyPersonInfo(userInfo);
        return ResultMapUtils.saveResult(i);
    }

    @PostMapping("/modifyperSonInfo")
    public HashMap<String, Object> modifyPersonSecurity(UserInfo userInfo, Model model) {
        int i = userInfoService.modifyPersonSecurity(userInfo);
        return ResultMapUtils.saveResult(i);
    }


}

