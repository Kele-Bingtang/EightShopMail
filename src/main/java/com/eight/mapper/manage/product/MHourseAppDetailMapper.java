package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.HourseAppDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mHourseAppDetailMapper")
public interface MHourseAppDetailMapper {

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
     * @param hourseAppDetailPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<HourseAppDetail> queryHourseAppDetailPage(@Param("hourseAppDetailPage") Page<HourseAppDetail> hourseAppDetailPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param hourseAppDetailId 用户地址id
     * @return 用户地址
     */
    HourseAppDetail queryHourseAppDetailById(Integer hourseAppDetailId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryHourseAppDetailCount();
}
