package com.eight.service;

import com.eight.bean.DeleteOrder;
import com.eight.utils.OrderQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IDeleteOrderService {
    List<DeleteOrder> viewDeleteOrder();

    void saveRequestUser(DeleteOrder deleteOrder);

    DeleteOrder modifyDeleteOrder(String orderId);

    void returnDeleteOrder(DeleteOrder deleteOrder);

    PageInfo<DeleteOrder> listOrderByName(OrderQuery orderQuery);
}
