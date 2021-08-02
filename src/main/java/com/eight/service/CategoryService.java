package com.eight.service;


import com.eight.bean.ProductCategory;

import java.util.List;

public interface CategoryService {
    public List<ProductCategory> queryCategoryNameBycategoryId(String categoryId);
}
