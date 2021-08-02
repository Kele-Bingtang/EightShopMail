package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mProductInfoMapper")
public interface MProductInfoMapper {

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
     * @param productInfoPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<ProductInfo> queryProductInfoPage(@Param("productInfoPage") Page<ProductInfo> productInfoPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productInfoId 用户地址id
     * @return 用户地址
     */
    ProductInfo queryProductInfoById(Integer productInfoId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryProductInfoCount();

    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId);

}
