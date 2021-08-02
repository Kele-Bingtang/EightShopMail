package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.ProductPicInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mProductPicInfoMapper")
public interface MProductPicInfoMapper {

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
     * @param productPicInfoPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<ProductPicInfo> queryProductPicInfoPage(@Param("productPicInfoPage") Page<ProductPicInfo> productPicInfoPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param productPicInfoId 用户地址id
     * @return 用户地址
     */
    ProductPicInfo queryProductPicInfoById(Integer productPicInfoId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryProductPicInfoCount();
}
