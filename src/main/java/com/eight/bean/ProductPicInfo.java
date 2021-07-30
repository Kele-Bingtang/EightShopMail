package com.eight.bean;

import java.sql.Timestamp;

public class ProductPicInfo {
    // 商品图片ID
    private Long productPicId;
    // 商品ID
    private Long productId;
    // 图片描述
    private String picDesc;
    // 图片URL
    private String picUrl;
    // 是否主图：0.非主图1.主图
    private Integer isMaster;
    // 图片是否有效：0无效 1有效
    private Integer picStatus;
    // 最后修改时间
    private Timestamp modifiedTime;

    private ProductInfo productInfo;

    // 无参构造器
    public ProductPicInfo() {
    }

    // 有参构造器，进行属性值的初始化
    public ProductPicInfo(Long productPicId, Long productId, String picDesc, String picUrl, Integer isMaster, Integer picStatus, Timestamp modifiedTime) {
        this.productPicId = productPicId;
        this.productId = productId;
        this.picDesc = picDesc;
        this.picUrl = picUrl;
        this.isMaster = isMaster;
        this.picStatus = picStatus;
        this.modifiedTime = modifiedTime;
    }

    // 获取 商品图片ID 的属性值
    public Long getProductPicId() {
        return productPicId;
    }

    // 设置 商品图片ID 的属性值
    public void setProductPicId(Long productPicId) {
        this.productPicId = productPicId;
    }

    // 获取 商品ID 的属性值
    public Long getProductId() {
        return productId;
    }

    // 设置 商品ID 的属性值
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // 获取 图片描述 的属性值
    public String getPicDesc() {
        return picDesc;
    }

    // 设置 图片描述 的属性值
    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }

    // 获取 图片URL 的属性值
    public String getPicUrl() {
        return picUrl;
    }

    // 设置 图片URL 的属性值
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    // 获取 是否主图：0.非主图1.主图 的属性值
    public Integer getIsMaster() {
        return isMaster;
    }

    // 设置 是否主图：0.非主图1.主图 的属性值
    public void setIsMaster(Integer isMaster) {
        this.isMaster = isMaster;
    }

    // 获取 图片是否有效：0无效 1有效 的属性值
    public Integer getPicStatus() {
        return picStatus;
    }

    // 设置 图片是否有效：0无效 1有效 的属性值
    public void setPicStatus(Integer picStatus) {
        this.picStatus = picStatus;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        return "ProductPicInfo {" +
                ", productPicId='" + productPicId + '\'' +
                ", productId='" + productId + '\'' +
                ", picDesc='" + picDesc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", isMaster='" + isMaster + '\'' +
                ", picStatus='" + picStatus + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}