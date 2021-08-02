package com.eight.bean;

public class ViewInfo {
    // productId ：
    private Integer productId;
    // productName ：
    private String productName;
    // oneCategoryId ：
    private Integer oneCategoryId;
    // twoCategoryId ：
    private Integer twoCategoryId;
    // picUrl ：
    private String picUrl;
    private String productCore;
    private long totalRecord=0;

    public String getProductCore() {
        return productCore;
    }

    public void setProductCore(String productCore) {
        this.productCore = productCore;
    }


    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    // 无参构造器
    public ViewInfo() {
    }

    // 有参构造器，进行属性值的初始化
    public ViewInfo(Integer productId, String productName, Integer oneCategoryId, Integer twoCategoryId, String picUrl, String productCore) {
        this.productId = productId;
        this.productName = productName;
        this.oneCategoryId = oneCategoryId;
        this.twoCategoryId = twoCategoryId;
        this.picUrl = picUrl;
        this.productCore=productCore;
    }

    // 获取 productId 的属性值
    public Integer getProductId() {
        return productId;
    }

    // 设置 productId 的属性值
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    // 获取 productName 的属性值
    public String getProductName() {
        return productName;
    }

    // 设置 productName 的属性值
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // 获取 oneCategoryId 的属性值
    public Integer getOneCategoryId() {
        return oneCategoryId;
    }

    // 设置 oneCategoryId 的属性值
    public void setOneCategoryId(Integer oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    // 获取 twoCategoryId 的属性值
    public Integer getTwoCategoryId() {
        return twoCategoryId;
    }

    // 设置 twoCategoryId 的属性值
    public void setTwoCategoryId(Integer twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    // 获取 picUrl 的属性值
    public String getPicUrl() {
        return picUrl;
    }

    // 设置 picUrl 的属性值
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "ViewInfo {" +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", oneCategoryId='" + oneCategoryId + '\'' +
                ", twoCategoryId='" + twoCategoryId + '\'' +
                ", picUrl='" + picUrl + '\'' +
                "}";
    }
}