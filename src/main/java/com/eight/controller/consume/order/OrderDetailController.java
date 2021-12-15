package com.eight.controller.consume.order;

import com.eight.bean.OrderDetail;
import com.eight.service.consume.order.IOrderDetailService;
import com.eight.service.consume.order.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/eight/orderDetail")
public class OrderDetailController {

    @Resource
    private IOrderDetailService orderDetailService;

    @Resource
    private IOrderService orderService;

    @GetMapping("deleteOrder")
    public String deleteOrder(String orderId, Model model) {
        orderService.deleteOrder(orderId);
        return "redirect:orderDetail";
    }

    @GetMapping("orderDetail")
    public String orderDetail(Model model) {
        model.addAttribute("orderDetails", orderDetailService.orderDetail());
        return "comsume/order/orderDetail";
    }

    @GetMapping("deleteOrderDetail")
    public String deleteOrderDetail(String orderId, Model model) {
        orderDetailService.deleteOrderDetail(orderId);
        return "redirect:orderDetail";
    }

    @GetMapping("getOrderProductById")
        public String getOrderProductById(String orderId, Model model) {
        List<OrderDetail> orderProductById = orderDetailService.getOrderProductById(orderId);
        for (OrderDetail orderDetail : orderProductById) {
            System.out.println(orderDetail);
        }
        model.addAttribute("orderDetails",orderDetailService.getOrderProductById(orderId));
        return "comsume/order/returnAndExchange";
    }
    @GetMapping("returnAndExchange")
    public String returnAndExchange() {
        return "comsume/order/returnAndExchange";
    }

    @GetMapping("loading")
    public String loading(){
        return "comsume/order/loading";
    }
}
