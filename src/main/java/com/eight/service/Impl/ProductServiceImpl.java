package com.eight.service.Impl;

import com.eight.bean.ProductInfo;
import com.eight.bean.ProductPicInfo;
import com.eight.mapper.ProductMapper;
import com.eight.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductInfo> queryAllProductInfo() {
        return productMapper.queryAllProductInfo();
    }

    @Override
    public List<ProductInfo> queryProductInfosByName(String productName) {
        return null;
    }

    @Override
    public ProductInfo queryProductInfoByName(String productName) {
        return null;
    }

    @Override
    public List<ProductInfo> queryProductInfoByCategory(String catrgoryId) {
        List<ProductInfo> productInfoList = productMapper.queryProductInfoByoneCategory(catrgoryId);
        if (productInfoList == null || productInfoList.size() == 0) {
            return productMapper.queryProductInfoBytwoCategory(catrgoryId);
        }
        return productInfoList;
    }

    @Override
    public List<ProductInfo> queryProductInfoBySeckill() {
        List<ProductInfo> productInfos = productMapper.queryAllProductInfo();
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Random random = new Random();
            productInfoList.add(i, productInfos.get(random.nextInt(productInfos.size())));
        }
        return productInfoList;
    }

    @Override
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code) {
        List<ProductInfo> productInfoList = new ArrayList<>();

        String[] codes = code.split("&");
        for (String s : codes) {
            ProductInfo productInfo = productMapper.queryProductInfoBycode(s);
            productInfoList.add(productInfo);
        }

        return productInfoList;

    }

    @Override
    public ProductInfo viewProductById(String productId) {
        return productMapper.viewProductById(productId);
    }
}
