package com.eight.bean;


public class DeleteOrder {
    private Long orderId;

    private String returnType;

    private String returnReason;

    private String returnPrice;

    private String ReturnDesc;

    private String returnState;

    public DeleteOrder(Long orderId, String returnType, String returnReason, String returnPrice, String returnDesc, String returnState) {
        this.orderId = orderId;
        this.returnType = returnType;
        this.returnReason = returnReason;
        this.returnPrice = returnPrice;
        ReturnDesc = returnDesc;
        this.returnState = returnState;
    } public DeleteOrder() {
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
        return ReturnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        ReturnDesc = returnDesc;
    }

    public String getReturnState() {
        return returnState;
    }

    public void setReturnState(String returnState) {
        this.returnState = returnState;
    }

    @Override
    public String toString() {
        return "DeleteOrder{" +
                "orderId=" + orderId +
                ", returnType='" + returnType + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", returnPrice='" + returnPrice + '\'' +
                ", ReturnDesc='" + ReturnDesc + '\'' +
                ", returnState='" + returnState + '\'' +
                '}';
    }
}


