package com.eight.bean;

import java.sql.Timestamp;


/**
 * @Author
 * @CreateTime 2021-07-22 11:35:47
 * @Version 1.0
 */
public class UserHead {
    // 头像ID
    private Long userHeadId;
    // 用户ID
    private Long userId;
    // 头像名称
    private String headName;
    // 头像的url
    private String headUrl;
    // 最后修改时间
    private Timestamp modifiedTime;

    // 无参构造器
    public UserHead() {
    }

    // 有参构造器，进行属性值的初始化
    public UserHead(Long userHeadId, Long userId, String headName, String headUrl, Timestamp modifiedTime) {
        this.userHeadId = userHeadId;
        this.userId = userId;
        this.headName = headName;
        this.headUrl = headUrl;
        this.modifiedTime = modifiedTime;
    }

    // 获取 头像ID 的属性值
    public Long getUserHeadId() {
        return userHeadId;
    }

    // 设置 头像ID 的属性值
    public void setUserHeadId(Long userHeadId) {
        this.userHeadId = userHeadId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 头像名称 的属性值
    public String getHeadName() {
        return headName;
    }

    // 设置 头像名称 的属性值
    public void setHeadName(String headName) {
        this.headName = headName;
    }

    // 获取 头像的url 的属性值
    public String getHeadUrl() {
        return headUrl;
    }

    // 设置 头像的url 的属性值
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
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
        return "UserHead {" +
                ", userHeadId='" + userHeadId + '\'' +
                ", userId='" + userId + '\'' +
                ", headName='" + headName + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}