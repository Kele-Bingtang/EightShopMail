package com.eight.service.consume.order.impl;

import com.eight.mapper.consume.order.OrderMapper;
import com.eight.service.consume.order.IOrderService;
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
}
