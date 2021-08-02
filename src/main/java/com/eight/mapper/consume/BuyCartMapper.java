package com.eight.mapper.consume;

import com.eight.bean.OrderDetail;
import com.eight.bean.OrderMaster;
import com.eight.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyCartMapper {
    ProductInfo viewProduct(Long productId);

    int addOrderMaster(OrderMaster orderMaster);

    int addOrderDetail(OrderDetail orderDetail);
}
