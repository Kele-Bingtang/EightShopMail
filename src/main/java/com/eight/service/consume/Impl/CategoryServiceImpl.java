package com.eight.service.consume.Impl;

import com.eight.bean.ProductCategory;
import com.eight.mapper.consume.CategoryMapper;
import com.eight.service.consume.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<ProductCategory> queryCategoryNameBycategoryId(String categoryId) {
        return categoryMapper.queryCategoryNameBycategoryId(categoryId);
    }
}
