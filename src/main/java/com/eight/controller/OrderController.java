package com.eight.controller;

import com.eight.service.IDeleteOrderService;
import com.eight.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orderDetail")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IDeleteOrderService deleteOrderService;


    @GetMapping("deleteOrder")
    public String deleteOrder(String orderId, HttpServletRequest request) {
        orderService.deleteOrder(orderId);
        return "redirect:orderDetail";
    }
}
