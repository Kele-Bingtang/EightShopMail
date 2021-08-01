package com.eight.service.consume;

import com.eight.bean.ProductInfo;

import java.util.List;
import java.util.Map;

public interface ViewService {
    public List<ProductInfo> queryViewInfoByCategoryId(String categoryId);
    public List<ProductInfo> queryProductInfoWithlimitWithCondition(String curPage, Map<String, String> conMap,String pageSize,String classPath,String detail_name,String categoryId);
    public List<ProductInfo> queryProductInfoWithlimit(int m,String pageSize,String sortCon,String oneCategoryId);
    public int queryCountFromProductInfoWithlimit(String oneCategoryId,String sortCon,int m,String pageSize);
    public int queryCountFromProductInfoWithCondition(String detailName,String condition,String sortCon,int m,String pageSize);
}
