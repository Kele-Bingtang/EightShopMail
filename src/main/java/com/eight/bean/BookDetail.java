package com.eight.bean;


/**
 * @Author kele
 * @CreateTime 2021-07-05 14:37:35
 * @Version 1.0
 */
public class BookDetail {
    // 详细id
    private Integer bDetailId;
    // 作者
    private String bAuthor;
    // 出版社
    private String bPublisher;
    // 商品编码
    private String productCore;

    private ProductInfo productInfo;

    // 无参构造器
    public BookDetail() {
    }

    // 有参构造器，进行属性值的初始化
    public BookDetail(Integer bDetailId, String bAuthor, String bPublisher, String productCore) {
        this.bDetailId = bDetailId;
        this.bAuthor = bAuthor;
        this.bPublisher = bPublisher;
        this.productCore = productCore;
    }

    public Integer getbDetailId() {
        return bDetailId;
    }

    public void setbDetailId(Integer bDetailId) {
        this.bDetailId = bDetailId;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbPublisher() {
        return bPublisher;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
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
        return "BookDetail {" +
                ", bDetailId='" + bDetailId + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bPublisher='" + bPublisher + '\'' +
                ", productCore='" + productCore + '\'' +
                "}";
    }
}