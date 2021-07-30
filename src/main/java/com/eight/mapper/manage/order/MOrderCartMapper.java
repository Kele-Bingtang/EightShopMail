package com.eight.mapper.manage.order;

import com.eight.bean.OrderCart;
import com.eight.bean.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mOrderCartMapper")
public interface MOrderCartMapper {

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
     * @param orderCartPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<OrderCart> queryOrderCartPage(@Param("orderCartPage") Page<OrderCart> orderCartPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param orderCartId 用户地址id
     * @return 用户地址
     */
    OrderCart queryOrderCartById(Integer orderCartId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryOrderCartCount();
}
