package com.eight.service.consume.Impl;

import com.eight.bean.ProductComment;
import com.eight.bean.ProductInfo;
import com.eight.mapper.consume.IndexMapper;
import com.eight.service.consume.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("indexServiceImpl")
public class IndexServiceImpl implements IIndexService {
    @Autowired
    IndexMapper indexMapper;

    @Override
    public List<ProductInfo> queryAllProductInfo() {
        return indexMapper.queryAllProductInfo();
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
        List<ProductInfo> productInfoList = indexMapper.queryProductInfoByoneCategory(catrgoryId);
        if (productInfoList == null || productInfoList.size() == 0) {
            return indexMapper.queryProductInfoBytwoCategory(catrgoryId);
        }
        return productInfoList;
    }

    @Override
    public List<ProductInfo> queryProductInfoBySeckill() {
        List<ProductInfo> productInfos = indexMapper.queryAllProductInfo();
        List<ProductInfo> productInfoList = new ArrayList<>();
        int repeatIndex = -1;
        int randomIndex = 0;
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            randomIndex = random.nextInt(productInfos.size());
            if(repeatIndex != randomIndex){
                productInfoList.add(i, productInfos.get(randomIndex));
            }else {
                i--;
            }
            repeatIndex = randomIndex;
        }
        return productInfoList;
    }

    @Override
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code) {
        List<ProductInfo> productInfoList = new ArrayList<>();

        String[] codes = code.split("&");
        for (String s : codes) {
            ProductInfo productInfo = indexMapper.queryProductInfoBycode(s);
            productInfoList.add(productInfo);
        }

        return productInfoList;

    }

    @Override
    public List<ProductComment> queryCommentArticleByNum(Integer artcleFine) {
        return indexMapper.queryCommentArticleByNum(artcleFine);
    }


}
