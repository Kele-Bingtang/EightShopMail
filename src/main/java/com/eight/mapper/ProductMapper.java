package com.eight.mapper;

import com.eight.bean.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productMapper")
public interface ProductMapper {

    /**
     * 查询所有商品
     *
     * @return 所有商品的集合
     */
    public List<ProductInfo> queryAllProductInfo();

    /**
     * 查询一些商品
     *
     * @param productName 商品名称
     * @return 一些商品的集合
     */
    public List<ProductInfo> queryProductInfosByName(String productName);

    /**
     * 查询一个商品
     *
     * @param productName 商品名称
     * @return 一个商品
     */
    public ProductInfo queryProductInfoByName(String productName);

    /**
     * 查询分类的商品
     *
     * @param catrgoryId 分类id
     * @return 分类商品
     */
    public List<ProductInfo> queryProductInfoByoneCategory(String catrgoryId);

    public List<ProductInfo> queryProductInfoBytwoCategory(String catrgoryId);

    public ProductInfo queryProductInfoBycode(String productCode);

}
