package com.eight.service.consume.order.impl;

import com.eight.bean.ProductInfo;
import com.eight.mapper.consume.order.ProductMapper;
import com.eight.service.consume.order.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductInfo viewProductById(String productId) {
        return productMapper.viewProductById(productId);
    }
}
