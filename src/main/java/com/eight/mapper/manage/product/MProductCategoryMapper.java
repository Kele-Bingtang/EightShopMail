package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mProductCategoryMapper")
public interface MProductCategoryMapper {

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
     * @param productCategoryPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<ProductCategory> queryProductCategoryPage(@Param("productCategoryPage") Page<ProductCategory> productCategoryPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productCategoryId 用户地址id
     * @return 用户地址
     */
    ProductCategory queryProductCategoryById(Integer productCategoryId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryProductCategoryCount();
}
