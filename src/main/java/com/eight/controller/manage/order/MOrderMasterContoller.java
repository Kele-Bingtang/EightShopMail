package com.eight.controller.manage.order;

import com.eight.bean.OrderMaster;
import com.eight.bean.Page;
import com.eight.service.manage.order.IMOrderMasterService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/orderMaster")
public class MOrderMasterContoller {

    @Autowired
    private IMOrderMasterService mOrderMasterService;

    @RequestMapping("/orderMasterManage")
    public String OrderMasterManage(){
        return "/manage/order/orderMasterManage";
    }

    @RequestMapping("/orderMasterPage")
    public String OrderMasterPage(){
        return "/manage/order/orderMasterPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryOrderMasterPage")
    @ResponseBody
    public HashMap<String,Object> queryOrderMasterPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<OrderMaster> OrderMasterPage = mOrderMasterService.queryOrderMasterPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(OrderMasterPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryOrderMasterList")
    @ResponseBody
    public HashMap<String,Object> queryOrderMasterList(){
        return ResultMapUtils.listResult(mOrderMasterService.queryOrderMasterList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addOrderMaster")
    @ResponseBody
    public HashMap<String,Object> addOrderMaster(OrderMaster orderMaster){
        int i = mOrderMasterService.addOrderMaster(orderMaster);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteOrderMaster")
    @ResponseBody
    public HashMap<String,Object> deleteOrderMaster(OrderMaster orderMaster){
        int i = mOrderMasterService.deleteOrderMaster(orderMaster);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyOrderMaster")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(OrderMaster orderMaster){
        int i = mOrderMasterService.modifyOrderMaster(orderMaster);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryOrderMasterById")
    public String queryOrderMasterById(int orderMasterId,Model model){
        OrderMaster orderMaster = mOrderMasterService.queryOrderMasterById(orderMasterId);
        model.addAttribute("obj", orderMaster);
        return "manage/order/orderMasterPage";
    }
}
