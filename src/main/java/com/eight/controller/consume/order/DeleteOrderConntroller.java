package com.eight.controller.consume.order;

import com.eight.bean.OrderQuery;
import com.eight.bean.OrderReturn;
import com.eight.service.consume.order.IDeleteOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/eight/orderDetail")
public class DeleteOrderConntroller {
    @Resource
    private IDeleteOrderService deleteOrderService;

//    @GetMapping("viewDeleteOrder")
//    public String viewDeleteOrder(HttpServletRequest request, HttpSession session) {
//        //把数据准备好，放入request作用域
//        request.setAttribute("deleteOrders", deleteOrderService.viewDeleteOrder());
//        for(int i=0;i<viewDeleteOrder().size();i++){
//        Long orderId=deleteOrderService.viewDeleteOrder().get(i).getOrderId();
//        String returnState1=deleteOrderService.viewDeleteOrder().get(i).getReturnState();
//            if (returnState1.equals("0")){
//                System.out.println("*********************请为订单***"+orderId+"***退货********************");
//            }else if(returnState1.equals("1")){
//                System.out.println("已为订单" + orderId + "退货");
//            }
//       }
//        return "requestUser";
//    }

    @GetMapping("modifyDeleteOrder")
    public String modifyDeleteOrder(String orderId, Model model) {
        model.addAttribute("modifyDeleteOrders", deleteOrderService.modifyDeleteOrder(orderId));
        return "comsume/order/modifyDeleteOrder";
    }
    @GetMapping("returnDeleteOrder")
    public String returnDeleteOrder(OrderReturn deleteOrder) {
        deleteOrderService.returnDeleteOrder(deleteOrder);
        return "comsume/order/requestUser";
    }

    private List<OrderReturn> viewDeleteOrder() {
        return deleteOrderService.viewDeleteOrder();
    }


    @PostMapping("saveRequestUser")
    public String saveRequestUser(OrderReturn orderReturn, Model model){
        deleteOrderService.saveRequestUser(orderReturn);
        return "comsume/order/requestUser";
    }
    @GetMapping("success")
    public String success(OrderReturn orderReturn){
        System.out.println(orderReturn);
        deleteOrderService.saveRequestUser(orderReturn);
        return "comsume/order/success";
    }

    @GetMapping("fenView")
    public String fenView(Model model, OrderQuery orderQuery){
        PageInfo<OrderReturn> orderPageInfo = deleteOrderService.listOrderByName(orderQuery);
        System.out.println(orderPageInfo);
        model.addAttribute("page",orderPageInfo);
        model.addAttribute("deleteOrders", deleteOrderService.viewDeleteOrder());
        for(int i=0;i<viewDeleteOrder().size();i++){
            Long orderId=deleteOrderService.viewDeleteOrder().get(i).getOrderId();
            String returnState1=deleteOrderService.viewDeleteOrder().get(i).getReturnState();
            if (returnState1.equals("0")){
                System.out.println("*********************请为订单***"+orderId+"***退货********************");
            }else if(returnState1.equals("1")){
                System.out.println("已为订单" + orderId + "退货");
            }
        }
        return "comsume/order/requestUser";
    }

}


