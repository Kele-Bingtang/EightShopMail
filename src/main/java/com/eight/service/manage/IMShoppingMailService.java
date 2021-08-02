package com.eight.service.manage;

import com.eight.bean.Page;
import com.eight.bean.ShoppingMail;

import java.util.List;

public interface IMShoppingMailService {

    /**
     * 通过用户地址名查询用户地址
     * @param shoppingMail 用户地址
     * @return 用户地址
     */
    public ShoppingMail queryShoppingMailByUsername(ShoppingMail shoppingMail);

    /**
     * 查询所有用户地址
     * @return 用户地址
     */
    public List<ShoppingMail> queryShoppingMailList();

    /**
     * 添加用户地址
     * @param shoppingMail 用户地址
     * @return 受影响的行数
     */
    public int addShoppingMail(ShoppingMail shoppingMail);
    /**
     * 删除用户地址
     * @param shoppingMail 用户地址
     * @return 受影响的行数
     */
    public int deleteShoppingMail(ShoppingMail shoppingMail);
    /**
     * 修改用户地址
     * @param shoppingMail 用户地址
     * @return 受影响的行数
     */
    public int modifyShoppingMail(ShoppingMail shoppingMail);

    /**
     * 分页查询
     * @param currentNum 当前页
     * @param singlePageSize 当前页的数据数
     * @param param 模糊查询
     * @return 页码Bean
     */
    Page<ShoppingMail> queryShoppingMailPage(int currentNum, int singlePageSize, String param);

    /**
     * 根据用户地址id查询用户地址
     * @param shoppingMailId 用户地址id
     * @return 用户地址
     */
    ShoppingMail queryShoppingMailById(Integer shoppingMailId);
}
