package com.eight.mapper.manage.order;

import com.eight.bean.OrderDetail;
import com.eight.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mOrderDetailMapper")
public interface MOrderDetailMapper {

    /**
     * 通过用户地址名查询用户地址
     * @param orderDetail 用户地址
     * @return 用户地址
     */
    public OrderDetail queryOrderDetailByUsername(OrderDetail orderDetail);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<OrderDetail> queryOrderDetailList();

    /**
     * 添加用户地址
     * @param orderDetail 用户地址
     * @return 受影响的行数
     */
    public int addOrderDetail(OrderDetail orderDetail);
    /**
     * 删除用户地址
     * @param orderDetail 用户地址
     * @return 受影响的行数
     */
    public int deleteOrderDetail(OrderDetail orderDetail);
    /**
     * 修改用户地址
     * @param orderDetail 用户地址
     * @return 受影响的行数
     */
    public int modifyOrderDetail(OrderDetail orderDetail);

    /**
     * 分页查询
     * @param orderDetailPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<OrderDetail> queryOrderDetailPage(@Param("orderDetailPage") Page<OrderDetail> orderDetailPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderDetailId 用户地址id
     * @return 用户地址
     */
    OrderDetail queryOrderDetailById(Integer orderDetailId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryOrderDetailCount();
}
