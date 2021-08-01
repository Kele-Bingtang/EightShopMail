package com.eight.bean;

import com.eight.utils.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class UserInfo {
    // 用户信息ID
    private Long userInfoId;
    // 用户ID
    private Long userId;
    // 昵称
    private String username;
    // 真实姓名
    private String realName;
    // 1 身份证，2 军官证，3 护照
    private Integer identityCardType;
    // 证件类型实例化 1 身份证，2 军官证，3 护照
    private String identityCardTypeStr;
    // 证件号码
    private String identityCardNo;
    // 性别
    private String userSex;
    // 手机号码
    private BigInteger mobilePhone;
    // 邮箱
    private String email;
    // 注册时间
    private Timestamp registerTime;
    // 生日
    private Timestamp birthday;
    // 用户余额
    private BigDecimal userMoney;
    // 最后修改时间
    private Timestamp modifiedTime;
    // 积分ID，识别等级
    private Integer userLevelId;
    // 积分数
    private Integer levelPoint;
    // 用户信息
    private User user;
    //用户头像
    private List<UserHead> userHeadList;
    //用户地址
    private List<UserAddr> userAddrList;
    //积分等级
    private UserLevel userLevel;

    // 无参构造器
    public UserInfo() {
    }

    // 有参构造器，进行属性值的初始化


    public UserInfo(Long userInfoId, Long userId, String username, String realName,
                    Integer identityCardType, String identityCardNo, String userSex,
                    BigInteger mobilePhone, String email, Timestamp registerTime, Timestamp birthday,
                    BigDecimal userMoney, Timestamp modifiedTime, Integer userLevel, Integer levelPoint) {
        this.userInfoId = userInfoId;
        this.userId = userId;
        this.username = username;
        this.realName = realName;
        this.identityCardType = identityCardType;
        this.identityCardNo = identityCardNo;
        this.userSex = userSex;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.registerTime = registerTime;
        this.birthday = birthday;
        this.userMoney = userMoney;
        this.modifiedTime = modifiedTime;
        this.userLevelId = userLevel;
        this.levelPoint = levelPoint;
    }

    // 获取 用户信息ID 的属性值
    public Long getUserInfoId() {
        return userInfoId;
    }

    // 设置 用户信息ID 的属性值
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    // 获取 用户ID 的属性值
    public Long getUserId() {
        return userId;
    }

    // 设置 用户ID 的属性值
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // 获取 昵称 的属性值
    public String getUsername() {
        return username;
    }

    // 设置 昵称 的属性值
    public void setUsername(String username) {
        this.username = username;
    }

    // 获取 真实姓名 的属性值
    public String getRealName() {
        return realName;
    }

    // 设置 真实姓名 的属性值
    public void setRealName(String realName) {
        this.realName = realName;
    }

    // 获取 1 身份证，2 军官证，3 护照 的属性值
    public Integer getIdentityCardType() {
        return identityCardType;
    }

    // 设置 1 身份证，2 军官证，3 护照 的属性值
    public void setIdentityCardType(Integer identityCardType) {
        this.identityCardType = identityCardType;
    }

    // 获取 证件号码 的属性值
    public String getIdentityCardNo() {
        return identityCardNo;
    }

    // 设置 证件号码 的属性值
    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    // 获取 性别 的属性值
    public String getUserSex() {
        return userSex;
    }

    // 设置 性别 的属性值
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    // 获取 手机号码 的属性值
    public BigInteger getMobilePhone() {
        return mobilePhone;
    }

    // 设置 手机号码 的属性值
    public void setMobilePhone(BigInteger mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    // 获取 邮箱 的属性值
    public String getEmail() {
        return email;
    }

    // 设置 邮箱 的属性值
    public void setEmail(String email) {
        this.email = email;
    }

    // 获取 注册时间 的属性值
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    // 设置 注册时间 的属性值
    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    // 获取 生日 的属性值
    public Timestamp getBirthday() {
        return birthday;
    }

    public String getBirthdayStr(){
        return DateUtil.dateConvertString(birthday);
    }

    // 设置 生日 的属性值
    public void setBirthday(String birthday) {
        this.birthday = DateUtil.dataConvertTimeStamp(birthday);
    }

    public void setBirthdayOrigin(Timestamp birthday) {
        this.birthday = birthday;
    }

    // 获取 用户余额 的属性值
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    // 设置 用户余额 的属性值
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    // 获取 最后修改时间 的属性值
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    // 设置 最后修改时间 的属性值
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    // 获取 积分ID，识别等级 的属性值
    public Integer getUserLevelId() {
        return userLevelId;
    }

    // 设置 积分ID，识别等级 的属性值
    public void setUserLevelId(Integer userLevelId) {
        this.userLevelId = userLevelId;
    }

    public Integer getLevelPoint() {
        return levelPoint;
    }

    public void setLevelPoint(Integer levelPoint) {
        this.levelPoint = levelPoint;
    }

    public String getIdentityCardTypeStr() {
        return identityCardTypeStr;
    }

    public void setIdentityCardTypeStr(String identityCardTypeStr) {
        this.identityCardTypeStr = identityCardTypeStr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserHead> getUserHeadList() {
        return userHeadList;
    }

    public void setUserHeadList(List<UserHead> userHeadList) {
        this.userHeadList = userHeadList;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public List<UserAddr> getUserAddrList() {
        return userAddrList;
    }

    public void setUserAddrList(List<UserAddr> userAddrList) {
        this.userAddrList = userAddrList;
    }

    // 重写toString方法，使用该方法可以在控制台打印属性的数据


    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", identityCardType=" + identityCardType +
                ", identityCardTypeStr='" + identityCardTypeStr + '\'' +
                ", identityCardNo='" + identityCardNo + '\'' +
                ", userSex='" + userSex + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", email='" + email + '\'' +
                ", registerTime=" + registerTime +
                ", birthday=" + birthday +
                ", userMoney=" + userMoney +
                ", modifiedTime=" + modifiedTime +
                ", userLevelId=" + userLevelId +
                ", levelPoint=" + levelPoint +
                ", user=" + user +
                ", userHeadList=" + userHeadList +
                ", userAddrList=" + userAddrList +
                ", userLevel=" + userLevel +
                '}';
    }
}