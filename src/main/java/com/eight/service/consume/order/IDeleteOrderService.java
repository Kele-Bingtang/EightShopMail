package com.eight.service.consume.order;

import com.eight.bean.OrderQuery;
import com.eight.bean.OrderReturn;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IDeleteOrderService {
    List<OrderReturn> viewDeleteOrder();

    void saveRequestUser(OrderReturn deleteOrder);

    OrderReturn modifyDeleteOrder(String orderId);

    void returnDeleteOrder(OrderReturn deleteOrder);

    PageInfo<OrderReturn> listOrderByName(OrderQuery orderQuery);
}
