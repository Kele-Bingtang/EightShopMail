package com.eight.bean;

public class UserBuyHistory {
	// 用户ID
	private Long userId;
	// 订单ID
	private Long orderId;

	// 无参构造器
	public UserBuyHistory() {
	}

	// 有参构造器，进行属性值的初始化
	public UserBuyHistory(Long userId, Long orderId) {
		this.userId = userId;
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

	// 获取 订单ID 的属性值
	public Long getOrderId() {
		return orderId;
	}

	// 设置 订单ID 的属性值
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据
	@Override
	public String toString(){
		return "UserBuyHistory {" + 
				", userId='" + userId + '\'' + 
				", orderId='" + orderId + '\'' + 
				"}";
	}
}