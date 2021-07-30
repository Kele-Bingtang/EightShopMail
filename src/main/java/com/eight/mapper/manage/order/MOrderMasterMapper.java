package com.eight.mapper.manage.order;

import com.eight.bean.OrderMaster;
import com.eight.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mOrderMasterMapper")
public interface MOrderMasterMapper {

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
     * @param orderMasterPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<OrderMaster> queryOrderMasterPage(@Param("orderMasterPage") Page<OrderMaster> orderMasterPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderMasterId 用户地址id
     * @return 用户地址
     */
    OrderMaster queryOrderMasterById(Integer orderMasterId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryOrderMasterCount();
}
