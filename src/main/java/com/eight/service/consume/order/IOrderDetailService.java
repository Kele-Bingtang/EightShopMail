package com.eight.service.consume.order;

import com.eight.bean.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderDetailService {
    List<OrderDetail> orderDetail();
    List<OrderDetail> getOrderProductById(String orderId);
    void deleteOrderDetail(String orderId);
}
