package com.eight.bean;

import java.sql.Timestamp;
/**
 * @Author
 * @CreateTime 2021-07-16 10:38:19
 * @Version 1.0
 */
public class User {
	// 用户ID
	private Long userId;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 0.在线 1.离线
	private Integer userStatus;
	// 最后修改时间
	private Timestamp modifiedTime;

	// 无参构造器
	public User() {
	}

	// 有参构造器，进行属性值的初始化
	public User(Long userId, String username, String password, Integer userStatus, Timestamp modifiedTime) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userStatus = userStatus;
		this.modifiedTime = modifiedTime;
	}

	// 获取 用户ID 的属性值
	public Long getUserId() {
		return userId;
	}

	// 设置 用户ID 的属性值
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// 获取 用户名 的属性值
	public String getUsername() {
		return username;
	}

	// 设置 用户名 的属性值
	public void setUsername(String username) {
		this.username = username;
	}

	// 获取 密码 的属性值
	public String getPassword() {
		return password;
	}

	// 设置 密码 的属性值
	public void setPassword(String password) {
		this.password = password;
	}

	// 获取 0.在线 1.离线 的属性值
	public Integer getUserStatus() {
		return userStatus;
	}

	// 设置 0.在线 1.离线 的属性值
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
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
	public String toString(){
		return "User {" + 
				", userId='" + userId + '\'' + 
				", username='" + username + '\'' + 
				", password='" + password + '\'' + 
				", userStatus='" + userStatus + '\'' + 
				", modifiedTime='" + modifiedTime + '\'' + 
				"}";
	}
}