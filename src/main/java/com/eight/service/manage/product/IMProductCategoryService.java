package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;

import java.util.List;

public interface IMProductCategoryService {

    /**
     * 通过用户地址名查询用户地址
     * @param productCategory 用户地址
     * @return 用户地址
     */
    public ProductCategory queryProductCategoryByUsername(ProductCategory productCategory);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<ProductCategory> queryProductCategoryList();

    /**
     * 添加用户地址
     * @param productCategory 用户地址
     * @return 受影响的行数
     */
    public int addProductCategory(ProductCategory productCategory);
    /**
     * 删除用户地址
     * @param productCategory 用户地址
     * @return 受影响的行数
     */
    public int deleteProductCategory(ProductCategory productCategory);
    /**
     * 修改用户地址
     * @param productCategory 用户地址
     * @return 受影响的行数
     */
    public int modifyProductCategory(ProductCategory productCategory);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<ProductCategory> queryProductCategoryPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productCategoryId 用户地址id
     * @return 用户地址
     */
    ProductCategory queryProductCategoryById(Integer productCategoryId);
}
