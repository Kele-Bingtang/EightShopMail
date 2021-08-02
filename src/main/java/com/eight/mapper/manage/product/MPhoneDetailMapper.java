package com.eight.mapper.manage.product;

import com.eight.bean.Page;
import com.eight.bean.PhoneDetail;
import com.eight.bean.ProductInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mPhoneDetailMapper")
public interface MPhoneDetailMapper {

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
     * @param phoneDetailPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<PhoneDetail> queryPhoneDetailPage(@Param("phoneDetailPage") Page<PhoneDetail> phoneDetailPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param phoneDetailId 用户地址id
     * @return 用户地址
     */
    PhoneDetail queryPhoneDetailById(Integer phoneDetailId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryPhoneDetailCount();


}
