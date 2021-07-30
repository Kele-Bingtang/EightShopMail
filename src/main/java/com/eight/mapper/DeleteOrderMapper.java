package com.eight.mapper;

import com.eight.bean.DeleteOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DeleteOrderMapper {
    List<DeleteOrder> viewDeleteOrder();
    void saveRequestUser(DeleteOrder deleteOrder);

    DeleteOrder modifyDeleteOrder(String orderId);

    void returnDeleteOrder(DeleteOrder deleteOrder);
}
