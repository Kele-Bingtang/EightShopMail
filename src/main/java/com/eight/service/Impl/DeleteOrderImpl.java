package com.eight.service.Impl;

import com.eight.bean.DeleteOrder;
import com.eight.mapper.DeleteOrderMapper;
import com.eight.service.IDeleteOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteOrderImpl implements IDeleteOrderService {
    @Autowired
    private DeleteOrderMapper deleteOrderMapper;

    @Override
    public List<DeleteOrder> viewDeleteOrder() {
        return deleteOrderMapper.viewDeleteOrder();
    }

    @Override
    public void saveRequestUser(DeleteOrder deleteOrder) {
        deleteOrderMapper.saveRequestUser(deleteOrder);
    }

    @Override
    public DeleteOrder modifyDeleteOrder(String orderId) {

        return deleteOrderMapper.modifyDeleteOrder(orderId);
    }

    @Override
    public void returnDeleteOrder(DeleteOrder deleteOrder) {

        deleteOrderMapper.returnDeleteOrder(deleteOrder);
    }

}
