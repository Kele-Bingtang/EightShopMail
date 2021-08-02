package com.eight.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderDetail {
    // 订单详情表ID
    private Long orderDetailId;
    // 订单表ID
    private Long orderId;
    // 订单商品ID
    private Long productId;
    // 商品名称
    private String productName;
    // 购买商品数量
    private Integer productAmount;
    // 购买商品单价
    private BigDecimal productPrice;
    // 优惠金额
    private BigDecimal freeMoney;
    // 最后修改时间
    private Timestamp modifiedTime;

    //在这里添加商品图片详情信息表
    private ProductPicInfo productPicInfo;
    //根据订单id找到Order_master表中一些需要的数据
    private OrderMaster orderMaster;
    //获取该商品的描述
    private ProductInfo productInfo;
    //根据用户的id查看该用户的订单
    private UserInfo userInfo;

    private List<Logistics> logistics;
    // 无参构造器
    public OrderDetail() {
    }

    // 有参构造器，进行属性值的初始化
    public OrderDetail(Long orderDetailId, Long orderId, Long productId, String productName, Integer productAmount, BigDecimal productPrice, BigDecimal feeMoney, Timestamp modifiedTime) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.freeMoney = feeMoney;
        this.modifiedTime = modifiedTime;
    }

    // 获取 订单详情表ID 的属性值
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    // 设置 订单详情表ID 的属性值
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    // 获取 订单表ID 的属性值
    public Long getOrderId() {
        return orderId;
    }

    // 设置 订单表ID 的属性值
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    // 获取 订单商品ID 的属性值
    public Long getProductId() {
        return productId;
    }

    // 设置 订单商品ID 的属性值
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // 获取 商品名称 的属性值
    public String getProductName() {
        return productName;
    }

    // 设置 商品名称 的属性值
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // 获取 购买商品数量 的属性值
    public Integer getProductAmount() {
        return productAmount;
    }

    // 设置 购买商品数量 的属性值
    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    // 获取 购买商品单价 的属性值
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    // 设置 购买商品单价 的属性值
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    // 获取 优惠金额 的属性值
    public BigDecimal getFreeMoney() {
        return freeMoney;
    }

    // 设置 优惠金额 的属性值
    public void setFreeMoney(BigDecimal freeMoney) {
        this.freeMoney = freeMoney;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public ProductPicInfo getProductPicInfo() {
        return productPicInfo;
    }

    public void setProductPicInfo(ProductPicInfo productPicInfo) {
        this.productPicInfo = productPicInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public OrderMaster getOrderMaster() {
        return orderMaster;
    }

    public void setOrderMaster(OrderMaster orderMaster) {
        this.orderMaster = orderMaster;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Logistics> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<Logistics> logistics) {
        this.logistics = logistics;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据


    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productAmount=" + productAmount +
                ", productPrice=" + productPrice +
                ", freeMoney=" + freeMoney +
                ", modifiedTime=" + modifiedTime +
                ", productPicInfo=" + productPicInfo +
                ", orderMaster=" + orderMaster +
                ", productInfo=" + productInfo +
                ", userInfo=" + userInfo +
                ", logistics=" + logistics +
                '}';
    }
}