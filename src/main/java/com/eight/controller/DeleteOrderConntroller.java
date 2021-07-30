package com.eight.controller;

import com.eight.bean.DeleteOrder;
import com.eight.service.IDeleteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orderDetail")
public class DeleteOrderConntroller {
    @Autowired
    private IDeleteOrderService deleteOrderService;

    @GetMapping("viewDeleteOrder")
    public String viewDeleteOrder(@RequestParam(defaultValue = "0") String returnState, HttpServletRequest request, HttpSession session) {
        //把数据准备好，放入request作用域
        request.setAttribute("deleteOrders", deleteOrderService.viewDeleteOrder());

        for(int i=0;i<viewDeleteOrder().size();i++){
        Long orderId=deleteOrderService.viewDeleteOrder().get(i).getOrderId();
            if (returnState.equals("0")){
                System.out.println("请为订单"+orderId+"退货");
            }else{
                System.out.println("已为订单" + orderId + "退货");
            }
       }
        return "requestUser";
    }

    @GetMapping("modifyDeleteOrder")
    public String modifyDeleteOrder(String orderId, Model model) {
        System.out.println(orderId);
        model.addAttribute("modifyDeleteOrders", deleteOrderService.modifyDeleteOrder(orderId));
        System.out.println(deleteOrderService.modifyDeleteOrder(orderId));
        return "modifyDeleteOrder";
    }
    @GetMapping("returnDeleteOrder")
    public String returnDeleteOrder(DeleteOrder deleteOrder) {
        deleteOrderService.returnDeleteOrder(deleteOrder);
        return "requestUser";
    }

    private List<DeleteOrder> viewDeleteOrder() {
        return deleteOrderService.viewDeleteOrder();
    }

    @GetMapping("returnAndExchange")
    public String returnAndExchange(Model model){
        return "returnAndExchange";
    }

    @PostMapping("saveRequestUser")
    public String saveRequestUser(DeleteOrder deleteOrder, Model model){
        deleteOrderService.saveRequestUser(deleteOrder);
        return "requestUser";
    }
    @GetMapping("success")
    public String success(DeleteOrder deleteOrder, Model model){
        deleteOrderService.saveRequestUser(deleteOrder);
        return "success";
    }
}


