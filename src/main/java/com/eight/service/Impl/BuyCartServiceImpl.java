package com.eight.service.Impl;

import com.eight.bean.ProductInfo;
import com.eight.mapper.BuyCartMapper;
import com.eight.service.IBuyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyCartServiceImpl implements IBuyCartService {
    @Autowired
    private BuyCartMapper buyCartMapper;


    @Override
    public ProductInfo viewBuyCart(Long productId) {
        return buyCartMapper.viewBuyCart(productId);
    }

    @Override
    public void insertOrder(long orderId) {
        buyCartMapper.insertOrder(orderId);
    }
}
