package com.eight.mapper;

import com.eight.bean.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    void deleteOrder(String orderId);
    OrderMaster getOrderById(String orderId);
    List<OrderMapper> viewOrder();

}
