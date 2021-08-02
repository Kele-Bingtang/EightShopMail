package com.eight.mapper.consume;

import com.eight.bean.Logistics;
import com.eight.bean.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogisticsMapper {
    //管理员向数据库插入物流信息
    void insertLogistics(Logistics logistics);

    //根据用户id和订单id搜索物流信息，不能关联在获取订单信息之后，因为当没有物流信息时会导致搜索不出其它消息
    List<Logistics> getLogistics(Long orderId, Long userId);

    //根据用户id查找用户的订单(所买的东西列表)
    List<OrderDetail> getOrdersList(Long userId);

    //根据订单id找到需要的商品的信息以及商品的物流信息
    List<OrderDetail> getOrder(Long orderId);
}
