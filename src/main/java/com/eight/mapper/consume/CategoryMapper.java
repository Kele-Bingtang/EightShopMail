package com.eight.mapper.consume;

import com.eight.bean.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryMapper")

public interface CategoryMapper {
    public List<ProductCategory> queryCategoryNameBycategoryId(String categoryId);
}
