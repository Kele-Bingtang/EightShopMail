package com.eight.controller.manage.user;

import com.eight.bean.Page;
import com.eight.bean.User;
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
@RequestMapping("/eight/manage/user")
public class MUserManageController {

    @Autowired
    private IMUserService mUserService;

    @RequestMapping("/userManage")
    public String userManage(){
        return "/manage/user/userManage";
    }

    @RequestMapping("/userPage")
    public String userPage(){
        return "/manage/user/userPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserPage")
    @ResponseBody
    public HashMap<String,Object> queryUserPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<User> userPage = mUserService.queryUserPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(userPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserList")
    @ResponseBody
    public HashMap<String,Object> queryUserList(){
        return ResultMapUtils.listResult(mUserService.queryUserList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public HashMap<String,Object> addUser(User user){
        int i = mUserService.addUser(user);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public HashMap<String,Object> deleteUser(User user){
        int i = mUserService.deleteUser(user);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(User user, Model model){
        int i = mUserService.modifyPassword(user);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserById")
    public String queryUserById(Long userId,Model model){
        User user = mUserService.queryUserById(userId);
        model.addAttribute("obj", user);
        return "manage/user/userPage";
    }
}
