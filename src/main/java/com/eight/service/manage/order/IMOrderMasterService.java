package com.eight.service.manage.order;

import com.eight.bean.OrderMaster;
import com.eight.bean.Page;

import java.util.List;

public interface IMOrderMasterService {

    /**
     * 通过用户地址名查询用户地址
     * @param orderMaster 用户地址
     * @return 用户地址
     */
    public OrderMaster queryOrderMasterByUsername(OrderMaster orderMaster);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<OrderMaster> queryOrderMasterList();

    /**
     * 添加用户地址
     * @param orderMaster 用户地址
     * @return 受影响的行数
     */
    public int addOrderMaster(OrderMaster orderMaster);
    /**
     * 删除用户地址
     * @param orderMaster 用户地址
     * @return 受影响的行数
     */
    public int deleteOrderMaster(OrderMaster orderMaster);
    /**
     * 修改用户地址
     * @param orderMaster 用户地址
     * @return 受影响的行数
     */
    public int modifyOrderMaster(OrderMaster orderMaster);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<OrderMaster> queryOrderMasterPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderMasterId 用户地址id
     * @return 用户地址
     */
    OrderMaster queryOrderMasterById(Integer orderMasterId);
}
