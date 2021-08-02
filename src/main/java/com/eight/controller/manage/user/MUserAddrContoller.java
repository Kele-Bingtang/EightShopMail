package com.eight.controller.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserAddr;
import com.eight.service.manage.user.IMUserAddrService;
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
@RequestMapping("/eight/manage/userAddr")
public class MUserAddrContoller {

    @Autowired
    private IMUserAddrService mUserAddrService;


    @RequestMapping("/userAddrManage")
    public String UserAddrManage(){
        return "/manage/user/userAddrManage";
    }

    @RequestMapping("/userAddrPage")
    public String UserAddrPage(Model model){
        model.addAttribute("users", mUserAddrService.queryUserList());
        return "/manage/user/userAddrPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserAddrPage")
    @ResponseBody
    public HashMap<String,Object> queryUserAddrPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserAddr> UserAddrPage = mUserAddrService.queryUserAddrPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserAddrPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserAddrList")
    @ResponseBody
    public HashMap<String,Object> queryUserAddrList(){
        return ResultMapUtils.listResult(mUserAddrService.queryUserAddrList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserAddr")
    @ResponseBody
    public HashMap<String,Object> addUserAddr(String username,UserAddr userAddr){
        int i = mUserAddrService.addUserAddr(username,userAddr);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserAddr")
    @ResponseBody
    public HashMap<String,Object> deleteUserAddr(UserAddr userAddr){
        int i = mUserAddrService.deleteUserAddr(userAddr);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserAddr")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserAddr userAddr){
        int i = mUserAddrService.modifyUserAddr(userAddr);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserAddrById")
    public String queryUserAddrById(int userAddrId,Model model){
        UserAddr userAddr = mUserAddrService.queryUserAddrById(userAddrId);
        model.addAttribute("obj", userAddr);
        return "manage/user/userAddrPage";
    }
}
