package com.eight.service.manage.order;

import com.eight.bean.OrderDetail;
import com.eight.bean.Page;

import java.util.List;

public interface IMOrderDetailService {

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
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<OrderDetail> queryOrderDetailPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderDetailId 用户地址id
     * @return 用户地址
     */
    OrderDetail queryOrderDetailById(Integer orderDetailId);
}
