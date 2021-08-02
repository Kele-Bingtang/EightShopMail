package com.eight.mapper.consume.order;

import com.eight.bean.OrderQuery;
import com.eight.bean.OrderReturn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteOrderMapper {

    List<OrderReturn> viewDeleteOrder();

    void saveRequestUser(OrderReturn deleteOrder);

    OrderReturn modifyDeleteOrder(String orderId);

    void returnDeleteOrder(OrderReturn deleteOrder);

    List<OrderReturn> listOrderByName(OrderQuery orderQuery);
}
