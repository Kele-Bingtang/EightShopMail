package com.eight.service;

import com.eight.bean.ProductInfo;

public interface IBuyCartService {
    ProductInfo viewBuyCart(Long productId);
    void insertOrder(long orderId);
}
