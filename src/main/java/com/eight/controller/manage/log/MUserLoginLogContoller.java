package com.eight.controller.manage.log;

import com.eight.bean.UserLoginLog;
import com.eight.bean.Page;
import com.eight.service.manage.log.IMUserLoginLogService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userLoginLog")
public class MUserLoginLogContoller {

    @Autowired
    private IMUserLoginLogService mUserLoginLogService;

    @RequestMapping("/userLoginLogManage")
    public String UserLoginLogManage(){
        return "/manage/log/userLoginLogManage";
    }

    @RequestMapping("/userLoginLogPage")
    public String UserLoginLogPage(){
        return "/manage/log/userLoginLogPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserLoginLogPage")
    @ResponseBody
    public HashMap<String,Object> queryUserLoginLogPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserLoginLog> UserLoginLogPage = mUserLoginLogService.queryUserLoginLogPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserLoginLogPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserLoginLogList")
    @ResponseBody
    public HashMap<String,Object> queryUserLoginLogList(){
        return ResultMapUtils.listResult(mUserLoginLogService.queryUserLoginLogList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserLoginLog")
    @ResponseBody
    public HashMap<String,Object> addUserLoginLog(UserLoginLog userLoginLog){
        int i = mUserLoginLogService.addUserLoginLog(userLoginLog);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserLoginLog")
    @ResponseBody
    public HashMap<String,Object> deleteUserLoginLog(UserLoginLog userLoginLog){
        int i = mUserLoginLogService.deleteUserLoginLog(userLoginLog);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserLoginLog")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserLoginLog userLoginLog){
        int i = mUserLoginLogService.modifyUserLoginLog(userLoginLog);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserLoginLogById")
    public String queryUserLoginLogById(int userLoginLogId,Model model){
        UserLoginLog userLoginLog = mUserLoginLogService.queryUserLoginLogById(userLoginLogId);
        model.addAttribute("obj", userLoginLog);
        return "manage/log/userLoginLogPage";
    }
}
