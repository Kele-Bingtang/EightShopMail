package com.eight.bean;

import java.math.BigInteger;
import java.sql.Timestamp;

public class ProductComment {
    // 评论ID
    private Long commentId;
    // 商品ID
    private Long productId;
    // 订单ID
    private BigInteger orderId;
    // 用户ID
    private Long userId;
    // 评论标题
    private String title;
    // 评论内容
    private String content;
    // 审核状态：0未审核，1已审核
    private Integer auditStatus;
    // 是否精品 0普通 1热评
    private Integer articleFine;
    // 评论时间
    private Timestamp auditTime;
    // 最后修改时间
    private Timestamp modifiedTime;

    private UserInfo userInfo;

    private ProductInfo productInfo;
    private UserHead userHead;
    private ProductPicInfo productPicInfo;

    // 无参构造器
    public ProductComment() {
    }

    // 有参构造器，进行属性值的初始化
    public ProductComment(Long commentId, Long productId, BigInteger orderId, Long userId, String title, String content, Integer auditStatus, Timestamp auditTime, Timestamp modifiedTime) {
        this.commentId = commentId;
        this.productId = productId;
        this.orderId = orderId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.auditStatus = auditStatus;
        this.auditTime = auditTime;
        this.modifiedTime = modifiedTime;
    }

    // 获取 评论ID 的属性值
    public Long getCommentId() {
        return commentId;
    }

    // 设置 评论ID 的属性值
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    // 获取 商品ID 的属性值
    public Long getProductId() {
        return productId;
    }

    // 设置 商品ID 的属性值
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // 获取 订单ID 的属性值
    public BigInteger getOrderId() {
        return orderId;
    }

    // 设置 订单ID 的属性值
    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 评论标题 的属性值
    public String getTitle() {
        return title;
    }

    // 设置 评论标题 的属性值
    public void setTitle(String title) {
        this.title = title;
    }

    // 获取 评论内容 的属性值
    public String getContent() {
        return content;
    }

    // 设置 评论内容 的属性值
    public void setContent(String content) {
        this.content = content;
    }

    // 获取 审核状态：0未审核，1已审核 的属性值
    public Integer getAuditStatus() {
        return auditStatus;
    }

    // 设置 审核状态：0未审核，1已审核 的属性值
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    // 获取 评论时间 的属性值
    public Timestamp getAuditTime() {
        return auditTime;
    }

    // 设置 评论时间 的属性值
    public void setAuditTime(Timestamp auditTime) {
        this.auditTime = auditTime;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getArticleFine() {
        return articleFine;
    }

    public void setArticleFine(Integer articleFine) {
        this.articleFine = articleFine;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public UserHead getUserHead() {
        return userHead;
    }

    public void setUserHead(UserHead userHead) {
        this.userHead = userHead;
    }

    public ProductPicInfo getProductPicInfo() {
        return productPicInfo;
    }

    public void setProductPicInfo(ProductPicInfo productPicInfo) {
        this.productPicInfo = productPicInfo;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据


    @Override
    public String toString() {
        return "ProductComment{" +
                "commentId=" + commentId +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", auditStatus=" + auditStatus +
                ", articleFine=" + articleFine +
                ", auditTime=" + auditTime +
                ", modifiedTime=" + modifiedTime +
                ", userInfo=" + userInfo +
                ", productInfo=" + productInfo +
                ", userHead=" + userHead +
                ", productPicInfo=" + productPicInfo +
                '}';
    }
}