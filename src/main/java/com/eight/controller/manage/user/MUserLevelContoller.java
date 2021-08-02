package com.eight.controller.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserLevel;
import com.eight.service.manage.user.IMUserLevelService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userLevel")
public class MUserLevelContoller {

    @Autowired
    private IMUserLevelService mUserLevelService;


    @RequestMapping("/userLevelManage")
    public String UserLevelManage(){
        return "/manage/user/userLevelManage";
    }

    @RequestMapping("/userLevelPage")
    public String UserLevelPage(){
        return "/manage/user/userLevelPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserLevelPage")
    @ResponseBody
    public HashMap<String,Object> queryUserLevelPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserLevel> UserLevelPage = mUserLevelService.queryUserLevelPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserLevelPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserLevelList")
    @ResponseBody
    public HashMap<String,Object> queryUserLevelList(){
        return ResultMapUtils.listResult(mUserLevelService.queryUserLevelList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserLevel")
    @ResponseBody
    public HashMap<String,Object> addUserLevel(UserLevel userLevel){
        int i = mUserLevelService.addUserLevel(userLevel);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserLevel")
    @ResponseBody
    public HashMap<String,Object> deleteUserLevel(UserLevel userLevel){
        int i = mUserLevelService.deleteUserLevel(userLevel);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserLevel")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserLevel userLevel){
        int i = mUserLevelService.modifyUserLevel(userLevel);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserLevelById")
    public String queryUserLevelById(int userLevelId,Model model){
        UserLevel userLevel = mUserLevelService.queryUserLevelById(userLevelId);
        model.addAttribute("obj", userLevel);
        return "manage/user/userLevelPage";
    }
}
