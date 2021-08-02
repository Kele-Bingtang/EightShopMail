package com.eight.controller.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserInfo;
import com.eight.service.manage.user.IMUserInfoService;
import com.eight.service.manage.user.IMUserService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userInfo")
public class MUserInfoController{

    @Autowired
    private IMUserInfoService mUserInfoService;



    @RequestMapping("/userInfoManage")
    public String UserInfoManage(){
        return "/manage/user/userInfoManage";
    }

    @RequestMapping("/userInfoPage")
    public String UserInfoPage(Model model){

        model.addAttribute("users", mUserInfoService.queryUserList());
        return "/manage/user/userInfoPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserInfoPage")
    @ResponseBody
    public HashMap<String,Object> queryUserInfoPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserInfo> userInfoPage = mUserInfoService.queryUserInfoPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(userInfoPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserInfoList")
    @ResponseBody
    public HashMap<String,Object> queryUserInfoList(Model model){
        return ResultMapUtils.listResult(mUserInfoService.queryUserInfoList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserInfo")
    @ResponseBody
    public HashMap<String,Object> addUserInfo(UserInfo userInfo){
        int i = mUserInfoService.addUserInfo(userInfo);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    public HashMap<String,Object> deleteUserInfo(UserInfo userInfo){
        int i = mUserInfoService.deleteUserInfo(userInfo);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserInfo")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserInfo userInfo){
        int i = mUserInfoService.modifyUserInfo(userInfo);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserInfoById")
    public String queryUserInfoById(int userInfoId,Model model){
        UserInfo userInfo = mUserInfoService.queryUserInfoById(userInfoId);
        model.addAttribute("obj", userInfo);
        return "manage/user/userInfoPage";
    }
}
