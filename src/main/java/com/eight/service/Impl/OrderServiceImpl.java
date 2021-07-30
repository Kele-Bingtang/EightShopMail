package com.eight.service.Impl;

import com.eight.bean.OrderMaster;
import com.eight.mapper.OrderMapper;
import com.eight.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void deleteOrder(String orderId) {
        orderMapper.deleteOrder(orderId);
    }

    @Override
    public OrderMaster getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }


}
