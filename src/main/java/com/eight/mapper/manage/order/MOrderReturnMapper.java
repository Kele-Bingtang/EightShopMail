package com.eight.mapper.manage.order;

import com.eight.bean.OrderReturn;
import com.eight.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mOrderReturnMapper")
public interface MOrderReturnMapper {

    /**
     * 通过用户地址名查询用户地址
     * @param orderReturn 用户地址
     * @return 用户地址
     */
    public OrderReturn queryOrderReturnByUsername(OrderReturn orderReturn);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<OrderReturn> queryOrderReturnList();

    /**
     * 添加用户地址
     * @param orderReturn 用户地址
     * @return 受影响的行数
     */
    public int addOrderReturn(OrderReturn orderReturn);
    /**
     * 删除用户地址
     * @param orderReturn 用户地址
     * @return 受影响的行数
     */
    public int deleteOrderReturn(OrderReturn orderReturn);
    /**
     * 修改用户地址
     * @param orderReturn 用户地址
     * @return 受影响的行数
     */
    public int modifyOrderReturn(OrderReturn orderReturn);

    /**
     * 分页查询
     * @param orderReturnPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<OrderReturn> queryOrderReturnPage(@Param("orderReturnPage") Page<OrderReturn> orderReturnPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderReturnId 用户地址id
     * @return 用户地址
     */
    OrderReturn queryOrderReturnById(Integer orderReturnId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryOrderReturnCount();
}
