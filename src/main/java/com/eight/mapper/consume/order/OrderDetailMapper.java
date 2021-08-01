package com.eight.mapper.consume.order;

import com.eight.bean.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDetailMapper {
    List<OrderDetail> orderDetail();
    List<OrderDetail> getOrderProductById(String orderId);
    void deleteOrderDetail(String orderId);

}
