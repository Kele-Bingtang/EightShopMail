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

    @GetMapping("getOrderProductById")
    public String getOrderProductById(String orderId, Model model) {
        System.out.println(orderDetailService.getOrderProductById("1"));
        model.addAttribute("orderDetails",orderDetailService.getOrderProductById("1"));
        return "returnAndExchange";
    }
    @GetMapping("returnAndExchange")
    public String returnAndExchange() {
        return "returnAndExchange";
    }
}
