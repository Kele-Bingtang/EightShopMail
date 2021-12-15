package com.eight.controller.manage;

import com.eight.bean.Page;
import com.eight.bean.ShoppingMail;
import com.eight.service.manage.IMShoppingMailService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/shoppingMail")
public class MShoppingMailContoller {

    @Autowired
    private IMShoppingMailService mShoppingMailService;

    @RequestMapping("/shoppingMailManage")
    public String ShoppingMailManage(){
        return "manage/shoppingMailManage";
    }

    @RequestMapping("/shoppingMailPage")
    public String ShoppingMailPage(){
        return "manage/shoppingMailPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryShoppingMailPage")
    @ResponseBody
    public HashMap<String,Object> queryShoppingMailPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<ShoppingMail> ShoppingMailPage = mShoppingMailService.queryShoppingMailPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(ShoppingMailPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryShoppingMailList")
    @ResponseBody
    public HashMap<String,Object> queryShoppingMailList(){
        return ResultMapUtils.listResult(mShoppingMailService.queryShoppingMailList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addShoppingMail")
    @ResponseBody
    public HashMap<String,Object> addShoppingMail(ShoppingMail shoppingMail){
        int i = mShoppingMailService.addShoppingMail(shoppingMail);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteShoppingMail")
    @ResponseBody
    public HashMap<String,Object> deleteShoppingMail(ShoppingMail shoppingMail){
        int i = mShoppingMailService.deleteShoppingMail(shoppingMail);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyShoppingMail")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(ShoppingMail shoppingMail){
        int i = mShoppingMailService.modifyShoppingMail(shoppingMail);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryShoppingMailById")
    public String queryShoppingMailById(int shoppingMailId,Model model){
        ShoppingMail shoppingMail = mShoppingMailService.queryShoppingMailById(shoppingMailId);
        model.addAttribute("obj", shoppingMail);
        return "manage/shoppingMailPage";
    }
}
