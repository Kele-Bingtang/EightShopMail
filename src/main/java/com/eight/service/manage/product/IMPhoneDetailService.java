package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.PhoneDetail;
import com.eight.bean.ProductInfo;
import com.eight.bean.ProductPicInfo;

import java.util.List;

public interface IMPhoneDetailService {

    /**
     * 通过用户地址名查询用户地址
     * @param phoneDetail 用户地址
     * @return 用户地址
     */
    public PhoneDetail queryPhoneDetailByUsername(PhoneDetail phoneDetail);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<PhoneDetail> queryPhoneDetailList();

    /**
     * 添加用户地址
     * @param phoneDetail 用户地址
     * @return 受影响的行数
     */
    public int addPhoneDetail(PhoneDetail phoneDetail);
    /**
     * 删除用户地址
     * @param phoneDetail 用户地址
     * @return 受影响的行数
     */
    public int deletePhoneDetail(PhoneDetail phoneDetail);
    /**
     * 修改用户地址
     * @param phoneDetail 用户地址
     * @return 受影响的行数
     */
    public int modifyPhoneDetail(PhoneDetail phoneDetail);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<PhoneDetail> queryPhoneDetailPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param phoneDetailId 用户地址id
     * @return 用户地址
     */
    PhoneDetail queryPhoneDetailById(Integer phoneDetailId);

    public List<ProductInfo> queryProductInfoList();

    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId);
}
