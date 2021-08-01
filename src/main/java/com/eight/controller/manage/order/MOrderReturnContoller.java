package com.eight.controller.manage.order;

import com.eight.bean.OrderReturn;
import com.eight.bean.Page;
import com.eight.service.manage.order.IMOrderReturnService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/orderReturn")
public class MOrderReturnContoller {

    @Autowired
    private IMOrderReturnService mOrderReturnService;

    @RequestMapping("/orderReturnManage")
    public String OrderReturnManage(){
        return "/manage/order/orderReturnManage";
    }

    @RequestMapping("/orderReturnPage")
    public String OrderReturnPage(){
        return "/manage/order/orderReturnPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryOrderReturnPage")
    @ResponseBody
    public HashMap<String,Object> queryOrderReturnPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<OrderReturn> OrderReturnPage = mOrderReturnService.queryOrderReturnPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(OrderReturnPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryOrderReturnList")
    @ResponseBody
    public HashMap<String,Object> queryOrderReturnList(){
        return ResultMapUtils.listResult(mOrderReturnService.queryOrderReturnList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addOrderReturn")
    @ResponseBody
    public HashMap<String,Object> addOrderReturn(OrderReturn orderReturn){
        int i = mOrderReturnService.addOrderReturn(orderReturn);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteOrderReturn")
    @ResponseBody
    public HashMap<String,Object> returnIddeleteOrderReturn(OrderReturn orderReturn){
        int i = mOrderReturnService.deleteOrderReturn(orderReturn);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改
     */
    @RequestMapping("/modifyOrderReturn")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(OrderReturn orderReturn,Long orderDetailId){
        int i = mOrderReturnService.modifyOrderReturn(orderReturn,orderDetailId);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryOrderReturnById")
    public String queryOrderReturnById(int orderReturnId,Model model){
        OrderReturn orderReturn = mOrderReturnService.queryOrderReturnById(orderReturnId);
        model.addAttribute("obj", orderReturn);
        return "manage/order/orderReturnPage";
    }
}
