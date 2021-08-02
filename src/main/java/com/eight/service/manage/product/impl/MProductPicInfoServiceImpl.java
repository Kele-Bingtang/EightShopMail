package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.ProductInfo;
import com.eight.bean.ProductPicInfo;
import com.eight.mapper.manage.product.MProductPicInfoMapper;
import com.eight.service.manage.product.IMProductInfoService;
import com.eight.service.manage.product.IMProductPicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mProductPicInfoServiceImpl")
public class MProductPicInfoServiceImpl implements IMProductPicInfoService {
    @Autowired
    private MProductPicInfoMapper mProductPicInfoMapper;
    @Autowired
    private IMProductInfoService mProductInfoService;
    @Override
    public ProductPicInfo queryProductPicInfoByUsername(ProductPicInfo productPicInfo) {
        return mProductPicInfoMapper.queryProductPicInfoByUsername(productPicInfo);
    }

    @Override
    public List<ProductPicInfo> queryProductPicInfoList() {
        return mProductPicInfoMapper.queryProductPicInfoList();
    }

    @Override
    public int addProductPicInfo(ProductPicInfo productPicInfo) {
        return mProductPicInfoMapper.addProductPicInfo(productPicInfo);
    }

    @Override
    public int deleteProductPicInfo(ProductPicInfo productPicInfo) {
        return mProductPicInfoMapper.deleteProductPicInfo(productPicInfo);
    }

    @Override
    public int modifyProductPicInfo(ProductPicInfo productPicInfo) {
        return mProductPicInfoMapper.modifyProductPicInfo(productPicInfo);
    }

    @Override
    public Page<ProductPicInfo> queryProductPicInfoPage(int currentNum, int singlePageSize, String param) {
        Page<ProductPicInfo> productPicInfoPage = new Page<>(currentNum,singlePageSize);
        List<ProductPicInfo> productPicInfoItem = mProductPicInfoMapper.queryProductPicInfoPage(productPicInfoPage, param);
        productPicInfoPage.setItem(productPicInfoItem);
        productPicInfoPage.setTotalPageCount(mProductPicInfoMapper.queryProductPicInfoCount());
        return productPicInfoPage;
    }

    @Override
    public ProductPicInfo queryProductPicInfoById(Integer productPicInfoId) {
        return mProductPicInfoMapper.queryProductPicInfoById(productPicInfoId);
    }

    @Override
    public List<ProductInfo> queryProductInfoList() {
        return mProductInfoService.queryProductInfoList();
    }
}
