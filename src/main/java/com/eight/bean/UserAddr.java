package com.eight.bean;

import java.sql.Timestamp;

public class UserAddr {
    // 地址ID
    private Long userAddrId;
    // 用户ID
    private Long userId;

    // 省份
    private String province;
    // 城市
    private String city;
    // 区
    private String district;
    // 具体的地址门牌号
    private String address;
    // 最后修改时间
    private Timestamp modifiedTime;

    private User User;

    // 无参构造器
    public UserAddr() {
    }

    // 有参构造器，进行属性值的初始化
    public UserAddr(Long userAddrId, Long userId, String province, String city, String district, String address, Timestamp modifiedTime) {
        this.userAddrId = userAddrId;
        this.userId = userId;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.modifiedTime = modifiedTime;
    }

    // 获取 地址ID 的属性值
    public Long getUserAddrId() {
        return userAddrId;
    }

    // 设置 地址ID 的属性值
    public void setUserAddrId(Long userAddrId) {
        this.userAddrId = userAddrId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    // 获取 省份的ID 的属性值
    public String getProvince() {
        return province;
    }

    // 设置 省份的ID 的属性值
    public void setProvince(String province) {
        this.province = province;
    }

    // 获取 城市的ID 的属性值
    public String getCity() {
        return city;
    }

    // 设置 城市的ID 的属性值
    public void setCity(String city) {
        this.city = city;
    }

    // 获取 区ID 的属性值
    public String getDistrict() {
        return district;
    }

    // 设置 区ID 的属性值
    public void setDistrict(String district) {
        this.district = district;
    }

    // 获取 具体的地址门牌号 的属性值
    public String getAddress() {
        return address;
    }

    // 设置 具体的地址门牌号 的属性值
    public void setAddress(String address) {
        this.address = address;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


    public com.eight.bean.User getUser() {
        return User;
    }

    public void setUser(com.eight.bean.User user) {
        User = user;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "UserAddr {" +
                ", userAddrId='" + userAddrId + '\'' +
                ", userId='" + userId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}