package com.eight.service.consume.Impl;

import com.eight.bean.Logistics;
import com.eight.bean.OrderDetail;
import com.eight.mapper.consume.logisticsMapper;
import com.eight.service.consume.logisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logisticsServiceImpl implements logisticsService {
    @Autowired
    private logisticsMapper logisticsmapper;

    @Override
    public void insertLogistics(Logistics logistics) {
       logisticsmapper.insertLogistics(logistics);
    }
    @Override
    public OrderDetail getOrder(String orderId) {
        return logisticsmapper.getOrder(orderId);
    }

    //根据用户id查找订单列表
    @Override
    public List<OrderDetail> getOrdersList(String userId) {
        return logisticsmapper.getOrdersList(userId);
    }

    @Override
    public List<Logistics> getLogistics(String orderId, String userId) {
        return logisticsmapper.getLogistics(orderId,userId);
    }

}
