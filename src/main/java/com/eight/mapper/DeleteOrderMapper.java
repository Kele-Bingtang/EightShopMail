package com.eight.mapper;

import com.eight.bean.DeleteOrder;
import com.eight.utils.OrderQuery;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
@Repository
public interface DeleteOrderMapper {

    List<DeleteOrder> viewDeleteOrder();

    void saveRequestUser(DeleteOrder deleteOrder);

    DeleteOrder modifyDeleteOrder(String orderId);

    void returnDeleteOrder(DeleteOrder deleteOrder);

    List<DeleteOrder> listOrderByName(OrderQuery orderQuery);
}
