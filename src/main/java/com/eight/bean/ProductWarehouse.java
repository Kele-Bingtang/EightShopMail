package com.eight.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ProductWarehouse {
    // 商品库存ID
    private Long pwId;
    // 商品ID
    private Long productId;
    // 当前商品数量
    private Long currentCnt;
    // 当前商品销量
    private Long productSales;
    // 当前商品卖出价格
    private BigDecimal productSellPrice;
    // 最后修改时间
    private Timestamp modifiedTime;

    // 无参构造器
    public ProductWarehouse() {
    }

    // 有参构造器，进行属性值的初始化
    public ProductWarehouse(Long pwId, Long productId, Long currentCnt, Long productSales, BigDecimal productSellPrice, Timestamp modifiedTime) {
        this.pwId = pwId;
        this.productId = productId;
        this.currentCnt = currentCnt;
        this.productSales = productSales;
        this.productSellPrice = productSellPrice;
        this.modifiedTime = modifiedTime;
    }

    // 获取 商品库存ID 的属性值
    public Long getPwId() {
        return pwId;
    }

    // 设置 商品库存ID 的属性值
    public void setPwId(Long pwId) {
        this.pwId = pwId;
    }

    // 获取 商品ID 的属性值
    public Long getProductId() {
        return productId;
    }

    // 设置 商品ID 的属性值
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // 获取 当前商品数量 的属性值
    public Long getCurrentCnt() {
        return currentCnt;
    }

    // 设置 当前商品数量 的属性值
    public void setCurrentCnt(Long currentCnt) {
        this.currentCnt = currentCnt;
    }

    // 获取 当前商品销量 的属性值
    public Long getProductSales() {
        return productSales;
    }

    // 设置 当前商品销量 的属性值
    public void setProductSales(Long productSales) {
        this.productSales = productSales;
    }

    // 获取 当前商品卖出价格 的属性值
    public BigDecimal getProductSellPrice() {
        return productSellPrice;
    }

    // 设置 当前商品卖出价格 的属性值
    public void setProductSellPrice(BigDecimal productSellPrice) {
        this.productSellPrice = productSellPrice;
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
        return "ProductWarehouse {" +
                ", pwId='" + pwId + '\'' +
                ", productId='" + productId + '\'' +
                ", currentCnt='" + currentCnt + '\'' +
                ", productSales='" + productSales + '\'' +
                ", productSellPrice='" + productSellPrice + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}