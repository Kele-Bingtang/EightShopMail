package com.eight.mapper.consume;

import com.eight.bean.OrderCart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


public interface CartMapper {

    static void updateAmountByCid(Long cartId, String username, Date now) {
    }

    /**
     * 插入购物车数据
     *
     * @param (“OrderCart”）string cart; 购物车数据
     * @return 受影响的行数
     */
    Integer insert(OrderCart cart);

    /**
     * 修改购物车中商品的数量
     *
     * @param ("cartId")             Integer cartId ; 购物车id
     * @param ("userId")             Integer userId ;用户id
     * @param ("productId")String    Integer productId 商品id
     * @param ("productTotalAmount") Integer productTotalAmount 种类数量
     * @param ("price")              Integer price;   商品价格
     * @param ("addTime")            Date addTime;添加时间
     * @param ("modifiedTime")       Date modifiedTime 最后修改时间
     * @return 受影响的行数
     */
    Integer updateAmountByCid(
            @Param("cartId") Integer cartId,
            @Param("userId") Integer userId,
            @Param("productId") Integer productId,
            @Param("price") Integer price,
            @Param("addTime") Integer addTime,
            @Param("productTotalAmount") Integer productTotalAmount,
            @Param("modifiedTime") Date modifiedTime
    );

    /**
     * 查询某用户在购物车添加的某商品的详情
     *
     * @param ("cartId")    Integer cartId; 购物车id;
     * @param ("userId")    Integer userId ;用户的id
     * @param ("productId") Integer productId;  商品的id
     * @return 匹配的购物车详情，如果该用户没有将该商品添加到购物车，则返回null
     */
    static CartMapper findByUidAndPid(
            @Param("cartId") Integer cartId,
            @Param("userId") Integer userId,
            @Param("productId") Integer productId
    ) {
        return CartMapper.findByUidAndPid(cartId,userId, productId);
    }

    Integer  updateAmountByCid(Integer userId, Integer cartId, Integer productTotalAmount, Integer price, Date addTime, Date modifiedTime);

    Long getCartId();

    Integer getAmount();
};


