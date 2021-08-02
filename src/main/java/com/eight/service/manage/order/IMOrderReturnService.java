package com.eight.service.manage.order;

import com.eight.bean.OrderReturn;
import com.eight.bean.Page;

import java.util.List;

public interface IMOrderReturnService {

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
    public int modifyOrderReturn(OrderReturn orderReturn,Long orderDetailId);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<OrderReturn> queryOrderReturnPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderReturnId 用户地址id
     * @return 用户地址
     */
    OrderReturn queryOrderReturnById(Integer orderReturnId);
}
