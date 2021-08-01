package com.eight.service.Impl;

import com.eight.bean.ProductInfo;
import com.eight.bean.ViewInfo;
import com.eight.mapper.ProductMapper;
import com.eight.mapper.ViewMapper;
import com.eight.service.BookDetailService;
import com.eight.service.ProductService;
import com.eight.service.ViewService;
import com.eight.utils.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("viewService")
public class ViewServiceImpl implements ViewService {
    @Autowired
    ViewMapper viewMapper;

    @Override
    public List<ProductInfo> queryViewInfoByCategoryId(String categoryId) {
        List<ProductInfo> productInfoList = viewMapper.queryViewInfoByoneCategoryId(categoryId);
        if (productInfoList == null || productInfoList.size() == 0) {
            return viewMapper.queryViewInfoBytwoCategoryId(categoryId);
        }
        return productInfoList;
    }

    @Override
    public List<ProductInfo> queryProductInfoWithlimitWithCondition(String curPage, Map<String, String> conMap, String pageSize, String classPath, String detailName, String categoryId) {
        int m = (Integer.parseInt(curPage) - 1) * Integer.parseInt(pageSize);
        if (!classPath.equals("") && !conMap.isEmpty()) {
            StringBuffer condition = new StringBuffer();
            for (Map.Entry<String, String> entry : conMap.entrySet()) {
                condition.append("(de." + entry.getKey() + "=" + entry.getValue() + ") and ");
            }
            condition = new StringBuffer(condition.toString().substring(0, condition.length() - " and ".length()));
            List<ProductInfo> list = viewMapper.queryProductInfoWithlimitWithCondition(detailName, categoryId, condition.toString(), "product_id", m, pageSize);
            int totalRecord = viewMapper.queryCountFromProductInfoWithCondition(detailName, condition.toString(), "product_id", m, pageSize);
            if (list.size() > 0) {
                list.get(0).setTotalRecord(totalRecord);
            }
            return list;
        }
        return queryProductInfoWithlimit(m, pageSize, "product_core", categoryId);
    }

    @Override
    public List<ProductInfo> queryProductInfoWithlimit(int m, String pageSize, String sortCon, String oneCategoryId) {
        List<ProductInfo> list = viewMapper.queryProductInfoWithlimit(m, pageSize, sortCon, oneCategoryId);
        list.get(0).setTotalRecord(viewMapper.queryCountFromProductInfoWithlimit(oneCategoryId, sortCon, 0, pageSize));
        return list;
    }

    @Override
    public int queryCountFromProductInfoWithlimit(String oneCategoryId, String sortCon, int m, String pageSize) {
        return viewMapper.queryCountFromProductInfoWithlimit(oneCategoryId, sortCon, m, pageSize);
    }

    @Override
    public int queryCountFromProductInfoWithCondition(String detaiName,String condition, String sortCon, int m, String pageSize) {
        return viewMapper.queryCountFromProductInfoWithCondition(detaiName,condition, sortCon, m, pageSize);
    }
}
