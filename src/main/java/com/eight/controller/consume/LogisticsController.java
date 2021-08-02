package com.eight.controller.consume;

import com.eight.bean.Logistics;
import com.eight.service.consume.logisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;


@Controller
@RequestMapping("/eight/user/index")
public class LogisticsController {
    @Autowired
    private logisticsService logisticsService;

    //点击我的淘宝后跳转到信息界面
    @GetMapping("insert")
    private String insert(){
    return "comsume/logistics/insertLogisticsInformation";
    }
//添加信息，即选择现在商品已经到达的地点，然后把这个地点加上字符串发给买家的物流信息页面
    @PostMapping("insertLogistics")
    private String insertInformation(Logistics logistics, Model model){
    logisticsService.insertLogistics(logistics);
    model.addAttribute("message","已完成");
    return "comsume/logistics/logistics";
    }

    @GetMapping("getLogistics")
    private String getLog(String user_id, String order_id, Model model){
        model.addAttribute("Logistics",logisticsService.getLogistics(order_id,"1"));
        return "comsume/logistics/ddd";
    }

    @GetMapping("propic")
    private String getPicByProId(Model model, String orderId){
        if(logisticsService.getOrder(orderId)==null){
        model.addAttribute("remain","商品正在飞速打包中，请耐心等待");
    }else
        model.addAttribute("Information",logisticsService.getOrder(orderId));
        //生成取件码
        Random random=new Random();
        int code=10000;
        code+=random.nextInt(99999);
        model.addAttribute("code",code);
        return "comsume/logistics/ddd";
    }

    @GetMapping("order")
    private String getMyOrders(Model model, String userId){
    ////登入后根据用户id判断用户是否已经买有东西,如果有则显示所有的订单消息,没有则提醒用户
        if(logisticsService.getOrdersList(userId).size()==0){
            model.addAttribute("remain","亲，您没有购买商品呢");
        }else

        for (int i = 0; i <logisticsService.getOrdersList(userId).size() ; i++) {
            model.addAttribute("Orders",logisticsService.getOrdersList(userId));
        }
        return "comsume/logistics/myorders";
    }


}

