package com.eight.service.consume;

import com.eight.bean.OrderDetail;
import com.eight.bean.OrderMaster;
import com.eight.bean.ProductInfo;

public interface IBuyCartService {
    ProductInfo viewProduct(Long productId);

    void addOrder(OrderMaster orderMaster);
}
