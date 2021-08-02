package com.eight.service.consume.Impl;

import com.eight.bean.Logistics;
import com.eight.bean.OrderDetail;
import com.eight.mapper.consume.LogisticsMapper;
import com.eight.service.consume.IIogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logisticsServiceImpl implements IIogisticsService {
    @Autowired
    private LogisticsMapper logisticsmapper;

    @Override
    public void insertLogistics(Logistics logistics) {
       logisticsmapper.insertLogistics(logistics);
    }
    @Override
    public List<OrderDetail> getOrder(Long orderId) {
        return logisticsmapper.getOrder(orderId);
    }

    //根据用户id查找订单列表
    @Override
    public List<OrderDetail> getOrdersList(Long userId) {
        return logisticsmapper.getOrdersList(userId);
    }

    @Override
    public List<Logistics> getLogistics(Long orderId, Long userId) {
        return logisticsmapper.getLogistics(orderId,userId);
    }

}
