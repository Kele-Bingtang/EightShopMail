package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;
import com.eight.bean.ProductInfo;
import com.eight.mapper.manage.product.MProductInfoMapper;
import com.eight.service.manage.product.IMProductCategoryService;
import com.eight.service.manage.product.IMProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mProductInfoServiceImpl")
public class MProductInfoServiceImpl implements IMProductInfoService {
    @Autowired
    private MProductInfoMapper mProductInfoMapper;
    @Autowired
    private IMProductCategoryService mProductCategoryService;
    @Override
    public ProductInfo queryProductInfoByUsername(ProductInfo productInfo) {
        return mProductInfoMapper.queryProductInfoByUsername(productInfo);
    }

    @Override
    public List<ProductInfo> queryProductInfoList() {
        return mProductInfoMapper.queryProductInfoList();
    }

    @Override
    public int addProductInfo(ProductInfo productInfo) {
        return mProductInfoMapper.addProductInfo(productInfo);
    }

    @Override
    public int deleteProductInfo(ProductInfo productInfo) {
        return mProductInfoMapper.deleteProductInfo(productInfo);
    }

    @Override
    public int modifyProductInfo(ProductInfo productInfo) {
        return mProductInfoMapper.modifyProductInfo(productInfo);
    }

    @Override
    public Page<ProductInfo> queryProductInfoPage(int currentNum, int singlePageSize, String param) {
        Page<ProductInfo> productInfoPage = new Page<>(currentNum,singlePageSize);
        List<ProductInfo> productInfoItem = mProductInfoMapper.queryProductInfoPage(productInfoPage, param);
        productInfoPage.setItem(productInfoItem);
        productInfoPage.setTotalPageCount(mProductInfoMapper.queryProductInfoCount());
        return productInfoPage;
    }

    @Override
    public ProductInfo queryProductInfoById(Integer productInfoId) {
        return mProductInfoMapper.queryProductInfoById(productInfoId);
    }

    public List<ProductCategory> queryProductCategoryList(){
        return mProductCategoryService.queryProductCategoryList();
    }

    @Override
    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId) {
        return mProductInfoMapper.queryProductInfoByCategory(categoryId);
    }
}
