package com.eight.service.manage.order;

import com.eight.bean.OrderCart;
import com.eight.bean.Page;

import java.util.List;

public interface IMOrderCartService {

    /**
     * 通过用户地址名查询用户地址
     * @param orderCart 用户地址
     * @return 用户地址
     */
    public OrderCart queryOrderCartByUsername(OrderCart orderCart);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<OrderCart> queryOrderCartList();

    /**
     * 添加用户地址
     * @param orderCart 用户地址
     * @return 受影响的行数
     */
    public int addOrderCart(OrderCart orderCart);
    /**
     * 删除用户地址
     * @param orderCart 用户地址
     * @return 受影响的行数
     */
    public int deleteOrderCart(OrderCart orderCart);
    /**
     * 修改用户地址
     * @param orderCart 用户地址
     * @return 受影响的行数
     */
    public int modifyOrderCart(OrderCart orderCart);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<OrderCart> queryOrderCartPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderCartId 用户地址id
     * @return 用户地址
     */
    OrderCart queryOrderCartById(Integer orderCartId);
}
