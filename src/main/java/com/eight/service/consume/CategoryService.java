package com.eight.service.consume;


import com.eight.bean.ProductCategory;

import java.util.List;

public interface CategoryService {
    public List<ProductCategory> queryCategoryNameBycategoryId(String categoryId);
}
