package com.eight.bean;

public class ShoppingMail {
    // 商城ID
    private Long shoppingMailId;
    // logo路径
    private String logUrl;
    // 商城名称
    private String shoppingMailName;
    // 商城联系人
    private String shoppingMailContacts;
    // 商城联系电话
    private Integer shoppingMailPhone;

    // 无参构造器
    public ShoppingMail() {
    }

    // 有参构造器，进行属性值的初始化
    public ShoppingMail(Long shoppingMailId, String logUrl, String shoppingMailName, String shoppingMailContacts, Integer shoppingMailPhone) {
        this.shoppingMailId = shoppingMailId;
        this.logUrl = logUrl;
        this.shoppingMailName = shoppingMailName;
        this.shoppingMailContacts = shoppingMailContacts;
        this.shoppingMailPhone = shoppingMailPhone;
    }

    // 获取 商城ID 的属性值
    public Long getShoppingMailId() {
        return shoppingMailId;
    }

    // 设置 商城ID 的属性值
    public void setShoppingMailId(Long shoppingMailId) {
        this.shoppingMailId = shoppingMailId;
    }

    // 获取 logo路径 的属性值
    public String getLogUrl() {
        return logUrl;
    }

    // 设置 logo路径 的属性值
    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    // 获取 商城名称 的属性值
    public String getShoppingMailName() {
        return shoppingMailName;
    }

    // 设置 商城名称 的属性值
    public void setShoppingMailName(String shoppingMailName) {
        this.shoppingMailName = shoppingMailName;
    }

    // 获取 商城联系人 的属性值
    public String getShoppingMailContacts() {
        return shoppingMailContacts;
    }

    // 设置 商城联系人 的属性值
    public void setShoppingMailContacts(String shoppingMailContacts) {
        this.shoppingMailContacts = shoppingMailContacts;
    }

    // 获取 商城联系电话 的属性值
    public Integer getShoppingMailPhone() {
        return shoppingMailPhone;
    }

    // 设置 商城联系电话 的属性值
    public void setShoppingMailPhone(Integer shoppingMailPhone) {
        this.shoppingMailPhone = shoppingMailPhone;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据

    @Override
    public String toString() {
        return "Shoppingmail{" +
                "shoppingMailId=" + shoppingMailId +
                ", logUrl='" + logUrl + '\'' +
                ", shoppingMailName='" + shoppingMailName + '\'' +
                ", shoppingMailContacts='" + shoppingMailContacts + '\'' +
                ", shoppingMailPhone=" + shoppingMailPhone +
                '}';
    }
}