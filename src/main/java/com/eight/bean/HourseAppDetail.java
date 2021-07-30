package com.eight.bean;

import java.math.BigDecimal;

public class HourseAppDetail {
    // 详细id
    private Integer hDetailId;
    // 高度
    private BigDecimal hHeight;
    // 宽度
    private BigDecimal hWidth;
    // 重量
    private BigDecimal hWeight;
    // 商品编码
    private String productCore;

    private ProductInfo productInfo;

    // 无参构造器
    public HourseAppDetail() {
    }

    // 有参构造器，进行属性值的初始化
    public HourseAppDetail(Integer hDetailId, BigDecimal hHeight, BigDecimal hWidth, BigDecimal hWeight, String productCore) {
        this.hDetailId = hDetailId;
        this.hHeight = hHeight;
        this.hWidth = hWidth;
        this.hWeight = hWeight;
        this.productCore = productCore;
    }

    public Integer gethDetailId() {
        return hDetailId;
    }

    public void sethDetailId(Integer hDetailId) {
        this.hDetailId = hDetailId;
    }

    public BigDecimal gethHeight() {
        return hHeight;
    }

    public void sethHeight(BigDecimal hHeight) {
        this.hHeight = hHeight;
    }

    public BigDecimal gethWidth() {
        return hWidth;
    }

    public void sethWidth(BigDecimal hWidth) {
        this.hWidth = hWidth;
    }

    public BigDecimal gethWeight() {
        return hWeight;
    }

    public void sethWeight(BigDecimal hWeight) {
        this.hWeight = hWeight;
    }

    // 获取 商品编码 的属性值
    public String getProductCore() {
        return productCore;
    }

    // 设置 商品编码 的属性值
    public void setProductCore(String productCore) {
        this.productCore = productCore;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "HourseAppDetail {" +
                ", hDetailId='" + hDetailId + '\'' +
                ", hHeight='" + hHeight + '\'' +
                ", hWidth='" + hWidth + '\'' +
                ", hWeight='" + hWeight + '\'' +
                ", productCore='" + productCore + '\'' +
                "}";
    }
}