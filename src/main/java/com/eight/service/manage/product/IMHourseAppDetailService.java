package com.eight.service.manage.product;

import com.eight.bean.Page;
import com.eight.bean.HourseAppDetail;
import com.eight.bean.ProductInfo;

import java.util.List;

public interface IMHourseAppDetailService {

    /**
     * 通过用户地址名查询用户地址
     * @param hourseAppDetail 用户地址
     * @return 用户地址
     */
    public HourseAppDetail queryHourseAppDetailByUsername(HourseAppDetail hourseAppDetail);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<HourseAppDetail> queryHourseAppDetailList();

    /**
     * 添加用户地址
     * @param hourseAppDetail 用户地址
     * @return 受影响的行数
     */
    public int addHourseAppDetail(HourseAppDetail hourseAppDetail);
    /**
     * 删除用户地址
     * @param hourseAppDetail 用户地址
     * @return 受影响的行数
     */
    public int deleteHourseAppDetail(HourseAppDetail hourseAppDetail);
    /**
     * 修改用户地址
     * @param hourseAppDetail 用户地址
     * @return 受影响的行数
     */
    public int modifyHourseAppDetail(HourseAppDetail hourseAppDetail);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<HourseAppDetail> queryHourseAppDetailPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param hourseAppDetailId 用户地址id
     * @return 用户地址
     */
    HourseAppDetail queryHourseAppDetailById(Integer hourseAppDetailId);

    public List<ProductInfo> queryProductInfoList();

    public List<ProductInfo> queryProductInfoByCategory(Integer categoryId);

}
