package com.eight.controller;

import com.eight.service.IOrderDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Resource
    private IOrderDetailService orderDetailService;

    @GetMapping("orderDetail")
    public String orderDetail(HttpServletRequest request) {
        request.setAttribute("orderDetails", orderDetailService.orderDetail());
        return "orderDetail";
    }

    @GetMapping("deleteOrderDetail")
    public String deleteOrderDetail(String orderId, HttpServletRequest request) {
        orderDetailService.deleteOrderDetail(orderId);
        return "redirect:orderDetail";
    }


    @GetMapping("loading")
    public String loading(Model model){
        return "loading";
    }

    @GetMapping("getOrderProductById")
    public String getOrderProductById(String orderId, Model model) {
        model.addAttribute("orderDetails", orderDetailService.getOrderProductById(orderId));
//        商品信息
        model.addAttribute("productCoreInfos", orderDetailService.getOrderProductById(orderId).getProductInfo().getProductCore());
        model.addAttribute("productNameInfos", orderDetailService.getOrderProductById(orderId).getProductName());
        model.addAttribute("productPrices", orderDetailService.getOrderProductById(orderId).getProductInfo().getPrice());

//        图片
        model.addAttribute("productPicInfos",orderDetailService.getOrderProductById(orderId).getProductPicInfo().getPicUrl());
        System.out.println(orderDetailService.getOrderProductById(orderId).getProductPicInfo().getPicUrl());
        return "orderDetail";
    }
}
