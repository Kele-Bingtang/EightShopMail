package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductInfo;
import com.eight.bean.ProductPicInfo;

import java.util.List;

public interface IMProductPicInfoService {

    /**
     * 通过用户地址名查询用户地址
     * @param productPicInfo 用户地址
     * @return 用户地址
     */
    public ProductPicInfo queryProductPicInfoByUsername(ProductPicInfo productPicInfo);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<ProductPicInfo> queryProductPicInfoList();

    /**
     * 添加用户地址
     * @param productPicInfo 用户地址
     * @return 受影响的行数
     */
    public int addProductPicInfo(ProductPicInfo productPicInfo);
    /**
     * 删除用户地址
     * @param productPicInfo 用户地址
     * @return 受影响的行数
     */
    public int deleteProductPicInfo(ProductPicInfo productPicInfo);
    /**
     * 修改用户地址
     * @param productPicInfo 用户地址
     * @return 受影响的行数
     */
    public int modifyProductPicInfo(ProductPicInfo productPicInfo);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<ProductPicInfo> queryProductPicInfoPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productPicInfoId 用户地址id
     * @return 用户地址
     */
    ProductPicInfo queryProductPicInfoById(Integer productPicInfoId);

    public List<ProductInfo> queryProductInfoList();
}
