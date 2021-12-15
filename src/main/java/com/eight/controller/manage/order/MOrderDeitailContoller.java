package com.eight.controller.manage.order;

import com.eight.bean.OrderDetail;
import com.eight.bean.Page;
import com.eight.service.manage.order.IMOrderDetailService;
import com.eight.utils.ResultMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/eight/manage/orderDetail")
public class MOrderDeitailContoller {

    @Autowired
    private IMOrderDetailService mOrderDetailService;

    @RequestMapping("/orderDetailManage")
    public String OrderDetailManage(){
        return "manage/order/orderDetailManage";
    }

    @RequestMapping("/orderDetailPage")
    public String OrderDetailPage(){
        return "manage/order/orderDetailPage";
    }

    /**
     * page: layui传来的当前页，固定
     * limit：layui传来的当前页数据数，固定
     */
    @RequestMapping("/queryOrderDetailPage")
    @ResponseBody
    public HashMap<String,Object> queryOrderDetailPage(@RequestParam(value = "page",defaultValue = "1") int currentNum, @RequestParam(value = "limit", defaultValue = "10") int singlePageSize, String param){
        Page<OrderDetail> OrderDetailPage = mOrderDetailService.queryOrderDetailPage(currentNum,singlePageSize,param);
        return ResultMapUtils.pageResult(OrderDetailPage);
    }

    /**
     * 获取用户的信息
     */
    @RequestMapping("/queryOrderDetailList")
    @ResponseBody
    public HashMap<String,Object> queryOrderDetailList(){
        return ResultMapUtils.listResult(mOrderDetailService.queryOrderDetailList());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addOrderDetail")
    @ResponseBody
    public HashMap<String,Object> addOrderDetail(OrderDetail orderDetail){
        int i = mOrderDetailService.addOrderDetail(orderDetail);
        return ResultMapUtils.saveResult(i);
    }
    /**
     * 删除用户
     */
    @RequestMapping("/deleteOrderDetail")
    @ResponseBody
    public HashMap<String,Object> deleteOrderDetail(OrderDetail orderDetail){
        int i = mOrderDetailService.deleteOrderDetail(orderDetail);
        return ResultMapUtils.deleteResult(i);
    }

    /**
     * 修改用户
     */
    @RequestMapping("/modifyOrderDetail")
    @ResponseBody
    public HashMap<String,Object> modifyPassword(OrderDetail orderDetail){
        int i = mOrderDetailService.modifyOrderDetail(orderDetail);
        return ResultMapUtils.saveResult(i);
    }

    /**
     * 通过id查询信息
     */
    @RequestMapping("/queryOrderDetailById")
    public String queryOrderDetailById(int orderDetailId,Model model){
        OrderDetail orderDetail = mOrderDetailService.queryOrderDetailById(orderDetailId);
        model.addAttribute("obj", orderDetail);
        return "manage/order/orderDetailPage";
    }
}
