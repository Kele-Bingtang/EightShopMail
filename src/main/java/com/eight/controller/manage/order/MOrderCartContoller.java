package com.eight.controller.manage.order;

import com.eight.bean.OrderCart;
import com.eight.bean.Page;
import com.eight.service.manage.order.IMOrderCartService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/orderCart")
public class MOrderCartContoller {

    @Autowired
    private IMOrderCartService mOrderCartService;

    @RequestMapping("/orderCartManage")
    public String OrderCartManage(){
        return "/manage/order/orderCartManage";
    }

    @RequestMapping("/orderCartPage")
    public String OrderCartPage(){
        return "/manage/order/orderCartPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryOrderCartPage")
    @ResponseBody
    public HashMap<String,Object> queryOrderCartPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<OrderCart> OrderCartPage = mOrderCartService.queryOrderCartPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(OrderCartPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryOrderCartList")
    @ResponseBody
    public HashMap<String,Object> queryOrderCartList(){
        return ResultMapUtils.listResult(mOrderCartService.queryOrderCartList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addOrderCart")
    @ResponseBody
    public HashMap<String,Object> addOrderCart(OrderCart orderCart){
        int i = mOrderCartService.addOrderCart(orderCart);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteOrderCart")
    @ResponseBody
    public HashMap<String,Object> deleteOrderCart(OrderCart orderCart){
        int i = mOrderCartService.deleteOrderCart(orderCart);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyOrderCart")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(OrderCart orderCart){
        int i = mOrderCartService.modifyOrderCart(orderCart);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryOrderCartById")
    public String queryOrderCartById(int orderCartId,Model model){
        OrderCart orderCart = mOrderCartService.queryOrderCartById(orderCartId);
        model.addAttribute("obj", orderCart);
        return "manage/order/orderCartPage";
    }
}
