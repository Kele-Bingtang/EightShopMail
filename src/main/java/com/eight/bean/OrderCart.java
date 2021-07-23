package com.eight.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderCart {
    // 购物车ID
    private Long cartId;
    // 用户ID
    private Long userId;
    // 商品ID
    private Long productId;
    // 加入购物车商品数量
    private Integer productTotalAmount;
    // 商品价格
    private BigDecimal price;
    // 加入购物车时间
    private Timestamp addTime;
    // 最后修改时间
    private Timestamp modifiedTime;

    // 无参构造器
    public OrderCart() {
    }

    // 有参构造器，进行属性值的初始化
    public OrderCart(Long cartId, Long userId, Long productId, Integer productTotalAmount, BigDecimal price, Timestamp addTime, Timestamp modifiedTime) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.productTotalAmount = productTotalAmount;
        this.price = price;
        this.addTime = addTime;
        this.modifiedTime = modifiedTime;
    }

    // 获取 购物车ID 的属性值
    public Long getCartId() {
        return cartId;
    }

    // 设置 购物车ID 的属性值
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 商品ID 的属性值
    public Long getProductId() {
        return productId;
    }

    // 设置 商品ID 的属性值
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // 获取 加入购物车商品数量 的属性值
    public Integer getProductTotalAmount() {
        return productTotalAmount;
    }

    // 设置 加入购物车商品数量 的属性值
    public void setProductTotalAmount(Integer productTotalAmount) {
        this.productTotalAmount = productTotalAmount;
    }

    // 获取 商品价格 的属性值
    public BigDecimal getPrice() {
        return price;
    }

    // 设置 商品价格 的属性值
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // 获取 加入购物车时间 的属性值
    public Timestamp getAddTime() {
        return addTime;
    }

    // 设置 加入购物车时间 的属性值
    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "OrderCart {" +
                ", cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", productTotalAmount='" + productTotalAmount + '\'' +
                ", price='" + price + '\'' +
                ", addTime='" + addTime + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}