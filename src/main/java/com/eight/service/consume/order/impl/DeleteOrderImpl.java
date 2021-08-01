package com.eight.service.consume.order.impl;

import com.eight.bean.OrderQuery;
import com.eight.bean.OrderReturn;
import com.eight.mapper.consume.order.DeleteOrderMapper;
import com.eight.service.consume.order.IDeleteOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteOrderImpl implements IDeleteOrderService {
    @Autowired
    private DeleteOrderMapper deleteOrderMapper;

    @Override
    public List<OrderReturn> viewDeleteOrder() {
        return deleteOrderMapper.viewDeleteOrder();
    }

    @Override
    public void saveRequestUser(OrderReturn orderReturn) {
        deleteOrderMapper.saveRequestUser(orderReturn);
    }

    @Override
    public OrderReturn modifyDeleteOrder(String orderId) {

        return deleteOrderMapper.modifyDeleteOrder(orderId);
    }

    @Override
    public void returnDeleteOrder(OrderReturn deleteOrder) {

        deleteOrderMapper.returnDeleteOrder(deleteOrder);
    }

    @Override
    public PageInfo<OrderReturn> listOrderByName(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery.getPageNum(),orderQuery.getPageSize());
        return new PageInfo<OrderReturn>(deleteOrderMapper.listOrderByName(orderQuery));
    }

}
