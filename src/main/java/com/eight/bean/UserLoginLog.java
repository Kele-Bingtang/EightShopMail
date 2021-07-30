package com.eight.bean;

import java.sql.Timestamp;

public class UserLoginLog {
	// 登陆日志ID
	private Long loginId;
	// 登陆用户ID
	private Long userId;
	// 用户登陆时间
	private Timestamp loginTime;
	// 登陆IP
	private Long loginIp;
	// 登陆类型：0未成功，1成功
	private Integer loginType;

	// 无参构造器
	public UserLoginLog() {
	}

	// 有参构造器，进行属性值的初始化
	public UserLoginLog(Long loginId, Long userId, Timestamp loginTime, Long loginIp, Integer loginType) {
		this.loginId = loginId;
		this.userId = userId;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.loginType = loginType;
	}

	// 获取 登陆日志ID 的属性值
	public Long getLoginId() {
		return loginId;
	}

	// 设置 登陆日志ID 的属性值
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	// 获取 登陆用户ID 的属性值
	public Long getUserId() {
		return userId;
	}

	// 设置 登陆用户ID 的属性值
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// 获取 用户登陆时间 的属性值
	public Timestamp getLoginTime() {
		return loginTime;
	}

	// 设置 用户登陆时间 的属性值
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	// 获取 登陆IP 的属性值
	public Long getLoginIp() {
		return loginIp;
	}

	// 设置 登陆IP 的属性值
	public void setLoginIp(Long loginIp) {
		this.loginIp = loginIp;
	}

	// 获取 登陆类型：0未成功，1成功 的属性值
	public Integer getLoginType() {
		return loginType;
	}

	// 设置 登陆类型：0未成功，1成功 的属性值
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据
	@Override
	public String toString(){
		return "UserLoginLog {" + 
				", loginId='" + loginId + '\'' + 
				", userId='" + userId + '\'' + 
				", loginTime='" + loginTime + '\'' + 
				", loginIp='" + loginIp + '\'' + 
				", loginType='" + loginType + '\'' + 
				"}";
	}
}