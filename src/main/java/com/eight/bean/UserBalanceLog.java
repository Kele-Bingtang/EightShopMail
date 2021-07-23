package com.eight.bean;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class UserBalanceLog {
    // 余额日志ID
    private Long balanceId;
    // 用户ID
    private Long userId;
    // 记录来源：1订单，2退货单
    private Integer source;
    // 相关单据ID
    private Long sourceSn;
    // 记录生成时间
    private Timestamp createTime;
    // 变动金额
    private BigDecimal amount;

    // 无参构造器
    public UserBalanceLog() {
    }

    // 有参构造器，进行属性值的初始化
    public UserBalanceLog(Long balanceId, Long userId, Integer source, Long sourceSn, Timestamp createTime, BigDecimal amount) {
        this.balanceId = balanceId;
        this.userId = userId;
        this.source = source;
        this.sourceSn = sourceSn;
        this.createTime = createTime;
        this.amount = amount;
    }

    // 获取 余额日志ID 的属性值
    public Long getBalanceId() {
        return balanceId;
    }

    // 设置 余额日志ID 的属性值
    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 记录来源：1订单，2退货单 的属性值
    public Integer getSource() {
        return source;
    }

    // 设置 记录来源：1订单，2退货单 的属性值
    public void setSource(Integer source) {
        this.source = source;
    }

    // 获取 相关单据ID 的属性值
    public Long getSourceSn() {
        return sourceSn;
    }

    // 设置 相关单据ID 的属性值
    public void setSourceSn(Long sourceSn) {
        this.sourceSn = sourceSn;
    }

    // 获取 记录生成时间 的属性值
    public Timestamp getCreateTime() {
        return createTime;
    }

    // 设置 记录生成时间 的属性值
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    // 获取 变动金额 的属性值
    public BigDecimal getAmount() {
        return amount;
    }

    // 设置 变动金额 的属性值
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据
    @Override
    public String toString() {
        return "UserBalanceLog {" +
                ", balanceId='" + balanceId + '\'' +
                ", userId='" + userId + '\'' +
                ", source='" + source + '\'' +
                ", sourceSn='" + sourceSn + '\'' +
                ", createTime='" + createTime + '\'' +
                ", amount='" + amount + '\'' +
                "}";
    }
}