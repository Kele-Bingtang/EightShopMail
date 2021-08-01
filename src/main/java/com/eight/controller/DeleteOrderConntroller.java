package com.eight.controller;

import com.eight.bean.DeleteOrder;
import com.eight.service.IDeleteOrderService;
import com.eight.utils.OrderQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orderDetail")
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


    @PostMapping("saveRequestUser")
    public String saveRequestUser(DeleteOrder deleteOrder, Model model){
        deleteOrderService.saveRequestUser(deleteOrder);
        return "requestUser";
    }
    @GetMapping("success")
    public String success(){
        return "success";
    }

    @GetMapping("fenView")
    public String fenView(Model model,OrderQuery orderQuery){
        PageInfo<DeleteOrder> orderPageInfo=deleteOrderService.listOrderByName(orderQuery);
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
        return "requestUser";
    }

}


