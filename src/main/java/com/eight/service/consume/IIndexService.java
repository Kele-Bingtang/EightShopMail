package com.eight.service.consume;

import com.eight.bean.ProductComment;
import com.eight.bean.ProductInfo;

import java.util.List;

public interface IIndexService {

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
    public List<ProductInfo> queryProductInfoByCategory(String catrgoryId);

    /**
     * 商品秒杀
     *
     * @return 商品
     */
    public List<ProductInfo> queryProductInfoBySeckill();

    /**
     * 模块商品信息
     *
     * @param boxName 模块名
     * @return 商品信息
     */
    public List<ProductInfo> queryProductInfoByBox(String boxName, String code);

    public List<ProductComment> queryCommentArticleByNum(Integer artcleFine);

}
