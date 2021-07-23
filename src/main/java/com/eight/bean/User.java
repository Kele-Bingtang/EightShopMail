package com.eight.bean;

import java.sql.Timestamp;
import java.util.List;

public class User {
    // 用户ID
    private Long userId;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 0.离线 1.在线
    private Integer userStatus;
    // 最后修改时间
    private Timestamp modifiedTime;
    // 用户地址
    private UserAddr userAddr;
    //用户等级
    private UserLevel userLevel;
    //用户信息
    private UserInfo userInfo;
    //用户头像
    private List<UserHead> userHeads;
    //用户购买历史记录
    private List<UserBuyHistory> userBuyHistories;

    // 无参构造器
    public User() {
    }

    // 有参构造器，进行属性值的初始化
    public User(Long userId, String username, String password, Integer userStatus, Timestamp modifiedTime, UserAddr userAddr, UserLevel userLevel, UserInfo userInfo, List<UserHead> userHeads, List<UserBuyHistory> userBuyHistories) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userStatus = userStatus;
        this.modifiedTime = modifiedTime;
        this.userAddr = userAddr;
        this.userLevel = userLevel;
        this.userInfo = userInfo;
        this.userHeads = userHeads;
        this.userBuyHistories = userBuyHistories;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 用户名 的属性值
    public String getUsername() {
        return username;
    }

    // 设置 用户名 的属性值
    public void setUsername(String username) {
        this.username = username;
    }

    // 获取 密码 的属性值
    public String getPassword() {
        return password;
    }

    // 设置 密码 的属性值
    public void setPassword(String password) {
        this.password = password;
    }

    // 获取 0.在线 1.离线 的属性值
    public Integer getUserStatus() {
        return userStatus;
    }

    // 设置 0.在线 1.离线 的属性值
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public UserAddr getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(UserAddr userAddr) {
        this.userAddr = userAddr;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserHead> getUserHeads() {
        return userHeads;
    }

    public void setUserHeads(List<UserHead> userHeads) {
        this.userHeads = userHeads;
    }

    public List<UserBuyHistory> getUserBuyHistories() {
        return userBuyHistories;
    }

    public void setUserBuyHistories(List<UserBuyHistory> userBuyHistories) {
        this.userBuyHistories = userBuyHistories;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userStatus=" + userStatus +
                ", modifiedTime=" + modifiedTime +
                ", userAddr=" + userAddr +
                ", userLevel=" + userLevel +
                ", userInfo=" + userInfo +
                ", userHeads=" + userHeads +
                ", userBuyHistories=" + userBuyHistories +
                '}';
    }
}