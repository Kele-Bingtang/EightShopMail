package com.eight.bean;

import java.sql.Timestamp;

public class UserPointLog {
    // 积分日志ID
    private Long pointId;
    // 用户ID
    private Long userId;
    // 积分来源：0订单，1登陆，2活动
    private Integer source;
    // 积分来源相关编号
    private Long referNumber;
    // 变更积分数
    private Integer changePoint;
    // 积分日志生成时间
    private Timestamp createTime;

    // 无参构造器
    public UserPointLog() {
    }

    // 有参构造器，进行属性值的初始化
    public UserPointLog(Long pointId, Long userId, Integer source, Long referNumber, Integer changePoint, Timestamp createTime) {
        this.pointId = pointId;
        this.userId = userId;
        this.source = source;
        this.referNumber = referNumber;
        this.changePoint = changePoint;
        this.createTime = createTime;
    }

    // 获取 积分日志ID 的属性值
    public Long getPointId() {
        return pointId;
    }

    // 设置 积分日志ID 的属性值
    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 积分来源：0订单，1登陆，2活动 的属性值
    public Integer getSource() {
        return source;
    }

    // 设置 积分来源：0订单，1登陆，2活动 的属性值
    public void setSource(Integer source) {
        this.source = source;
    }

    // 获取 积分来源相关编号 的属性值
    public Long getReferNumber() {
        return referNumber;
    }

    // 设置 积分来源相关编号 的属性值
    public void setReferNumber(Long referNumber) {
        this.referNumber = referNumber;
    }

    // 获取 变更积分数 的属性值
    public Integer getChangePoint() {
        return changePoint;
    }

    // 设置 变更积分数 的属性值
    public void setChangePoint(Integer changePoint) {
        this.changePoint = changePoint;
    }

    // 获取 积分日志生成时间 的属性值
    public Timestamp getCreateTime() {
        return createTime;
    }

    // 设置 积分日志生成时间 的属性值
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "UserPointLog {" +
                ", pointId='" + pointId + '\'' +
                ", userId='" + userId + '\'' +
                ", source='" + source + '\'' +
                ", referNumber='" + referNumber + '\'' +
                ", changePoint='" + changePoint + '\'' +
                ", createTime='" + createTime + '\'' +
                "}";
    }
}