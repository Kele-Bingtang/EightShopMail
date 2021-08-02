package com.eight.service.manage.product.impl;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;
import com.eight.mapper.manage.product.MProductCategoryMapper;
import com.eight.service.manage.product.IMProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mProductCategoryServiceImpl")
public class MProductCategoryServiceImpl implements IMProductCategoryService {
    @Autowired
    private MProductCategoryMapper mProductCategoryMapper;
    @Override
    public ProductCategory queryProductCategoryByUsername(ProductCategory productCategory) {
        return mProductCategoryMapper.queryProductCategoryByUsername(productCategory);
    }

    @Override
    public List<ProductCategory> queryProductCategoryList() {
        return mProductCategoryMapper.queryProductCategoryList();
    }

    @Override
    public int addProductCategory(ProductCategory productCategory) {
        if(productCategory.getParentId() == null){
            productCategory.setParentId(0);
        }
        if(productCategory.getCategoryLevel() == null){
            productCategory.setCategoryLevel(1);
        }
        if(productCategory.getCategoryStatus() == null){
            productCategory.setCategoryStatus(1);
        }
        return mProductCategoryMapper.addProductCategory(productCategory);
    }

    @Override
    public int deleteProductCategory(ProductCategory productCategory) {
        return mProductCategoryMapper.deleteProductCategory(productCategory);
    }

    @Override
    public int modifyProductCategory(ProductCategory productCategory) {
        return mProductCategoryMapper.modifyProductCategory(productCategory);
    }

    @Override
    public Page<ProductCategory> queryProductCategoryPage(int currentNum, int singlePageSize, String param) {
        Page<ProductCategory> productCategoryPage = new Page<>(currentNum,singlePageSize);
        List<ProductCategory> productCategoryItem = mProductCategoryMapper.queryProductCategoryPage(productCategoryPage, param);
        productCategoryPage.setItem(productCategoryItem);
        productCategoryPage.setTotalPageCount(mProductCategoryMapper.queryProductCategoryCount());
        return productCategoryPage;
    }

    @Override
    public ProductCategory queryProductCategoryById(Integer productCategoryId) {
        return mProductCategoryMapper.queryProductCategoryById(productCategoryId);
    }
}
