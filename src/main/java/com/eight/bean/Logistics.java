package com.eight.bean;

import java.sql.Timestamp;

public class Logistics {
    //物流id
    private Long logisticsId;
    //用户id
    private Long userId;
    //订单id
    private Long orderId;
    //消息
    private String message;
    //当前时间
    private Timestamp modifiedTime;
    //无参构造函数

    public Logistics(){

    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    @Override
    public String toString() {
        return "Logistics{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", message='" + message + '\'' +
                ", currentTime=" + modifiedTime +
                '}';
    }
}