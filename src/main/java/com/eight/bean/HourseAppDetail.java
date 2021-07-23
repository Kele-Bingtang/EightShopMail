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

    // 获取 详细id 的属性值
    public Integer getHDetailId() {
        return hDetailId;
    }

    // 设置 详细id 的属性值
    public void setHDetailId(Integer hDetailId) {
        this.hDetailId = hDetailId;
    }

    // 获取 高度 的属性值
    public BigDecimal getHHeight() {
        return hHeight;
    }

    // 设置 高度 的属性值
    public void setHHeight(BigDecimal hHeight) {
        this.hHeight = hHeight;
    }

    // 获取 宽度 的属性值
    public BigDecimal getHWidth() {
        return hWidth;
    }

    // 设置 宽度 的属性值
    public void setHWidth(BigDecimal hWidth) {
        this.hWidth = hWidth;
    }

    // 获取 重量 的属性值
    public BigDecimal getHWeight() {
        return hWeight;
    }

    // 设置 重量 的属性值
    public void setHWeight(BigDecimal hWeight) {
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