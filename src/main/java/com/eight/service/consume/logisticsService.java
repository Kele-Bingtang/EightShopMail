package com.eight.service.consume;

import com.eight.bean.Logistics;
import com.eight.bean.OrderDetail;

import java.util.List;

public interface logisticsService {


    //管理员向数据库插入信息，然后用户在物流页面那里查看消息
    void insertLogistics(Logistics logistics);
    //根据订单id并结合其它表找到需要的消息
    OrderDetail getOrder(String orderId);
    //查看我的订单
    List<OrderDetail> getOrdersList(String userId);
    //根据用户id和订单id绑定物流信息
    List<Logistics> getLogistics(String orderId, String userId);

}
