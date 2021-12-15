package com.eight.controller.manage.log;

import com.eight.bean.Page;
import com.eight.bean.UserPointLog;
import com.eight.service.manage.log.IMUserPointLogService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userPointLog")
public class MUserPointLogContoller {

    @Autowired
    private IMUserPointLogService mUserPointLogService;

    @RequestMapping("/userPointLogManage")
    public String UserPointLogManage(){
        return "manage/log/userPointLogManage";
    }

    @RequestMapping("/userPointLogPage")
    public String UserPointLogPage(){
        return "manage/log/userPointLogPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserPointLogPage")
    @ResponseBody
    public HashMap<String,Object> queryUserPointLogPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserPointLog> UserPointLogPage = mUserPointLogService.queryUserPointLogPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserPointLogPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserPointLogList")
    @ResponseBody
    public HashMap<String,Object> queryUserPointLogList(){
        return ResultMapUtils.listResult(mUserPointLogService.queryUserPointLogList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserPointLog")
    @ResponseBody
    public HashMap<String,Object> addUserPointLog(UserPointLog userPointLog){
        int i = mUserPointLogService.addUserPointLog(userPointLog);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserPointLog")
    @ResponseBody
    public HashMap<String,Object> deleteUserPointLog(UserPointLog userPointLog){
        int i = mUserPointLogService.deleteUserPointLog(userPointLog);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserPointLog")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserPointLog userPointLog){
        int i = mUserPointLogService.modifyUserPointLog(userPointLog);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserPointLogById")
    public String queryUserPointLogById(int userPointLogId,Model model){
        UserPointLog userPointLog = mUserPointLogService.queryUserPointLogById(userPointLogId);
        model.addAttribute("obj", userPointLog);
        return "manage/log/userPointLogPage";
    }
}
