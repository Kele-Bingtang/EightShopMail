package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;
import com.eight.bean.ProductInfo;

import java.util.List;

public interface IMProductInfoService {

    /**
     * 通过用户地址名查询用户地址
     * @param productInfo 用户地址
     * @return 用户地址
     */
    public ProductInfo queryProductInfoByUsername(ProductInfo productInfo);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<ProductInfo> queryProductInfoList();

    /**
     * 添加用户地址
     * @param productInfo 用户地址
     * @return 受影响的行数
     */
    public int addProductInfo(ProductInfo productInfo);
    /**
     * 删除用户地址
     * @param productInfo 用户地址
     * @return 受影响的行数
     */
    public int deleteProductInfo(ProductInfo productInfo);
    /**
     * 修改用户地址
     * @param productInfo 用户地址
     * @return 受影响的行数
     */
    public int modifyProductInfo(ProductInfo productInfo);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<ProductInfo> queryProductInfoPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productInfoId 用户地址id
     * @return 用户地址
     */
    ProductInfo queryProductInfoById(Integer productInfoId);

    public List<ProductCategory> queryProductCategoryList();

    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId);

}
