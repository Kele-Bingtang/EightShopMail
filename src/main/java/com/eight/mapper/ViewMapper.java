package com.eight.mapper;

import com.eight.bean.ProductInfo;
import com.eight.bean.ViewInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("viewMapper")
public interface ViewMapper {
    public List<ProductInfo> queryViewInfoByoneCategoryId(String oneCategoryId);
    public List<ProductInfo> queryViewInfoBytwoCategoryId(String twoCategoryId);
    public List<ProductInfo> queryProductInfoWithlimitWithCondition(String detailName,String oneCategoryId,String condition,String sortCon,int m,String pageSize);
    public List<ProductInfo> queryProductInfoWithlimit(int m,String pageSize,String sortCon,String oneCategoryId);
    public int queryCountFromProductInfoWithlimit(String oneCategoryId,String sortCon,int m,String pageSize);
    public int queryCountFromProductInfoWithCondition(String detailName,String condition,String sortCon,int m,String pageSize);
}
