package com.eight.mapper;

import com.eight.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyCartMapper {
    ProductInfo viewBuyCart(Long productId);
    void insertOrder(long orderId);
}
