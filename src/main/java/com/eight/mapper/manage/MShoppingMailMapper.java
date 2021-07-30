package com.eight.mapper.manage;

import com.eight.bean.Page;
import com.eight.bean.ShoppingMail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mShoppingMailMapper")
public interface MShoppingMailMapper {

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
     * @param shoppingMailPage 页数bean
     * @param param 模糊查询
     * @return 用户结果集
     */
    public List<ShoppingMail> queryShoppingMailPage(@Param("shoppingMailPage") Page<ShoppingMail> shoppingMailPage, @Param("param") String param);

    /**
     * 根据用户地址id查询用户地址
     * @param shoppingMailId 用户地址id
     * @return 用户地址
     */
    ShoppingMail queryShoppingMailById(Integer shoppingMailId);

    /**
     * 查询全部数据的总数
     * @return 总数
     */
    public int queryShoppingMailCount();
}
