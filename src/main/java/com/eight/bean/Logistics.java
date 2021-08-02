package com.eight.bean;

import java.sql.Timestamp;

public class Logistics {
    //用户id
    private int userId;
    //订单id
    private int orderId;
    //消息
    private String message;
    //当前时间
    private Timestamp currentTime;
    //无参构造函数
    public Logistics(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }
    @Override
    public String toString() {
        return "Logistics{" +
                "userId=" + userId +
                ", orderId=" + orderId +
                ", message='" + message + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}