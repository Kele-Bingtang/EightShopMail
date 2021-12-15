package com.eight.controller.manage.user;

import com.eight.bean.Page;
import com.eight.bean.UserBuyHistory;
import com.eight.service.manage.user.IMUserBuyHistoryService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/userBuyHistory")
public class MUserBuyHisContoller {

    @Autowired
    private IMUserBuyHistoryService mUserBuyHistoryService;

    @RequestMapping("/userBuyHistoryManage")
    public String UserBuyHistoryManage(){
        return "manage/user/userBuyHistoryManage";
    }

    @RequestMapping("/userBuyHistoryPage")
    public String UserBuyHistoryPage(){
        return "manage/user/userBuyHistoryPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryUserBuyHistoryPage")
    @ResponseBody
    public HashMap<String,Object> queryUserBuyHistoryPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<UserBuyHistory> UserBuyHistoryPage = mUserBuyHistoryService.queryUserBuyHistoryPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(UserBuyHistoryPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryUserBuyHistoryList")
    @ResponseBody
    public HashMap<String,Object> queryUserBuyHistoryList(){
        return ResultMapUtils.listResult(mUserBuyHistoryService.queryUserBuyHistoryList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUserBuyHistory")
    @ResponseBody
    public HashMap<String,Object> addUserBuyHistory(UserBuyHistory userBuyHistory){
        int i = mUserBuyHistoryService.addUserBuyHistory(userBuyHistory);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteUserBuyHistory")
    @ResponseBody
    public HashMap<String,Object> deleteUserBuyHistory(UserBuyHistory userBuyHistory){
        int i = mUserBuyHistoryService.deleteUserBuyHistory(userBuyHistory);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyUserBuyHistory")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(UserBuyHistory userBuyHistory){
        int i = mUserBuyHistoryService.modifyUserBuyHistory(userBuyHistory);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryUserBuyHistoryById")
    public String queryUserBuyHistoryById(int userBuyHistoryId,Model model){
        UserBuyHistory userBuyHistory = mUserBuyHistoryService.queryUserBuyHistoryById(userBuyHistoryId);
        model.addAttribute("obj", userBuyHistory);
        return "manage/user/userBuyHistoryPage";
    }
}
