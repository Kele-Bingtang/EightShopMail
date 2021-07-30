package com.eight.controller.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserBalanceLog;
import com.eight.service.manage.log.IMUserBalanceLogService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userBalanceLog")
public class MUserBalanceLogContoller {

    @Autowired
    private IMUserBalanceLogService mUserBalanceLogService;

    @RequestMapping("/userBalanceLogManage")
    public String UserBalanceLogManage(){
        return "/manage/log/userBalanceLogManage";
    }

    @RequestMapping("/userBalanceLogPage")
    public String UserBalanceLogPage(){
        return "/manage/log/userBalanceLogPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserBalanceLogPage")
    @ResponseBody
    public HashMap<String,Object> queryUserBalanceLogPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserBalanceLog> UserBalanceLogPage = mUserBalanceLogService.queryUserBalanceLogPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserBalanceLogPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserBalanceLogList")
    @ResponseBody
    public HashMap<String,Object> queryUserBalanceLogList(){
        return ResultMapUtils.listResult(mUserBalanceLogService.queryUserBalanceLogList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserBalanceLog")
    @ResponseBody
    public HashMap<String,Object> addUserBalanceLog(UserBalanceLog userBalanceLog){
        int i = mUserBalanceLogService.addUserBalanceLog(userBalanceLog);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserBalanceLog")
    @ResponseBody
    public HashMap<String,Object> deleteUserBalanceLog(UserBalanceLog userBalanceLog){
        int i = mUserBalanceLogService.deleteUserBalanceLog(userBalanceLog);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserBalanceLog")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserBalanceLog userBalanceLog){
        int i = mUserBalanceLogService.modifyUserBalanceLog(userBalanceLog);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserBalanceLogById")
    public String queryUserBalanceLogById(int userBalanceLogId,Model model){
        UserBalanceLog userBalanceLog = mUserBalanceLogService.queryUserBalanceLogById(userBalanceLogId);
        model.addAttribute("obj", userBalanceLog);
        return "manage/log/userBalanceLogPage";
    }
}
