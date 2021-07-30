package com.eight.service.Impl;

import com.eight.bean.OrderDetail;
import com.eight.mapper.OrderDetailMapper;
import com.eight.service.IOrderDetailService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class OrderDetailServiceImpl implements IOrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Override
    public List<OrderDetail> orderDetail() {
        return orderDetailMapper.orderDetail();
    }
    @Override
    public OrderDetail getOrderProductById(String orderId) {
        return orderDetailMapper.getOrderProductById(orderId);
    }
    @Override
    public void deleteOrderDetail(String orderId) {
        orderDetailMapper.deleteOrderDetail(orderId);
    }
}


