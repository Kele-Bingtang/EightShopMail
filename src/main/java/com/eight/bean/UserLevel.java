package com.eight.bean;

import java.sql.Timestamp;

public class UserLevel {
    // 积分ID
    private Integer userLevel;
    // 级别名称
    private String levelName;
    // 级别最低积分
    private Integer minPoint;
    // 级别最高积分
    private Integer maxPoint;
    // 最后修改时间
    private Timestamp modifiedTime;

    // 无参构造器
    public UserLevel() {
    }

    // 有参构造器，进行属性值的初始化
    public UserLevel(Integer userLevel, String levelName, Integer minPoint, Integer maxPoint, Timestamp modifiedTime) {
        this.userLevel = userLevel;
        this.levelName = levelName;
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
        this.modifiedTime = modifiedTime;
    }

    // 获取 积分ID 的属性值
    public Integer getUserLevel() {
        return userLevel;
    }

    // 设置 积分ID 的属性值
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    // 获取 级别名称 的属性值
    public String getLevelName() {
        return levelName;
    }

    // 设置 级别名称 的属性值
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    // 获取 级别最低积分 的属性值
    public Integer getMinPoint() {
        return minPoint;
    }

    // 设置 级别最低积分 的属性值
    public void setMinPoint(Integer minPoint) {
        this.minPoint = minPoint;
    }

    // 获取 级别最高积分 的属性值
    public Integer getMaxPoint() {
        return maxPoint;
    }

    // 设置 级别最高积分 的属性值
    public void setMaxPoint(Integer maxPoint) {
        this.maxPoint = maxPoint;
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
        return "UserLevel {" +
                ", userLevel='" + userLevel + '\'' +
                ", levelName='" + levelName + '\'' +
                ", minPoint='" + minPoint + '\'' +
                ", maxPoint='" + maxPoint + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                "}";
    }
}