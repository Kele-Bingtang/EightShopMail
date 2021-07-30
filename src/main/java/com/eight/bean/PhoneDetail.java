package com.eight.bean;

import java.math.BigDecimal;

public class PhoneDetail {
    // 详细信息ID
    private Integer pDetailId;
    // 高度
    private BigDecimal pHeight;
    // 宽度
    private BigDecimal pWidth;
    // 尺寸
    private BigDecimal pSize;
    // 重量
    private BigDecimal pWeight;
    // 机身颜色
    private String pColor;
    // 套餐类型
    private String pMeal;
    // 版本
    private String pVersion;
    // 内存容量
    private String pCapacity;
    // 商品编码
    private String productCore;

    private ProductInfo productInfo;

    // 无参构造器
    public PhoneDetail() {
    }

    // 有参构造器，进行属性值的初始化
    public PhoneDetail(Integer pDetailId, BigDecimal pHeight, BigDecimal pWidth, BigDecimal pSize, BigDecimal pWeight, String pColor, String pMeal, String pVersion, String pCapacity, String productCore) {
        this.pDetailId = pDetailId;
        this.pHeight = pHeight;
        this.pWidth = pWidth;
        this.pSize = pSize;
        this.pWeight = pWeight;
        this.pColor = pColor;
        this.pMeal = pMeal;
        this.pVersion = pVersion;
        this.pCapacity = pCapacity;
        this.productCore = productCore;
    }

    public Integer getpDetailId() {
        return pDetailId;
    }

    public void setpDetailId(Integer pDetailId) {
        this.pDetailId = pDetailId;
    }

    public BigDecimal getpHeight() {
        return pHeight;
    }

    public void setpHeight(BigDecimal pHeight) {
        this.pHeight = pHeight;
    }

    public BigDecimal getpWidth() {
        return pWidth;
    }

    public void setpWidth(BigDecimal pWidth) {
        this.pWidth = pWidth;
    }

    public BigDecimal getpSize() {
        return pSize;
    }

    public void setpSize(BigDecimal pSize) {
        this.pSize = pSize;
    }

    public BigDecimal getpWeight() {
        return pWeight;
    }

    public void setpWeight(BigDecimal pWeight) {
        this.pWeight = pWeight;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpMeal() {
        return pMeal;
    }

    public void setpMeal(String pMeal) {
        this.pMeal = pMeal;
    }

    public String getpVersion() {
        return pVersion;
    }

    public void setpVersion(String pVersion) {
        this.pVersion = pVersion;
    }

    public String getpCapacity() {
        return pCapacity;
    }

    public void setpCapacity(String pCapacity) {
        this.pCapacity = pCapacity;
    }

    public String getProductCore() {
        return productCore;
    }

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
        return "PhoneDetail {" +
                ", pDetailId='" + pDetailId + '\'' +
                ", pHeight='" + pHeight + '\'' +
                ", pWidth='" + pWidth + '\'' +
                ", pSize='" + pSize + '\'' +
                ", pWeight='" + pWeight + '\'' +
                ", pColor='" + pColor + '\'' +
                ", pMeal='" + pMeal + '\'' +
                ", pVersion='" + pVersion + '\'' +
                ", pCapacity='" + pCapacity + '\'' +
                ", productCore='" + productCore + '\'' +
                "}";
    }
}