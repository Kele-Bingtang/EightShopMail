package com.eight.bean;

import java.sql.Timestamp;

public class OrderReturn {
    private Long returnId;
    private Long orderId;
    private String returnType;
    private String returnReason;
    private String returnPrice;
    private String returnDesc;
    private String returnState;

    private Timestamp modified_time;

    private OrderDetail orderDetail;
    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public String getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(String returnPrice) {
        this.returnPrice = returnPrice;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    public Timestamp getModified_time() {
        return modified_time;
    }

    public void setModified_time(Timestamp modified_time) {
        this.modified_time = modified_time;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "OrderReturn{" +
                "returnId=" + returnId +
                ", orderId=" + orderId +
                ", returnType='" + returnType + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", returnPrice='" + returnPrice + '\'' +
                ", returnDesc='" + returnDesc + '\'' +
                ", returnState='" + returnState + '\'' +
                ", modified_time=" + modified_time +
                '}';
    }
}
