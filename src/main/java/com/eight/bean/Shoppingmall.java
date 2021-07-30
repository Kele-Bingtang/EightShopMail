package com.eight.bean;

public class Shoppingmall {
	// 商城ID
	private Long shoppingMallId;
	// logo路径
	private String logUrl;
	// 商城名称
	private String shoppingMallName;
	// 商城联系人
	private String shoppingMallContacts;
	// 商城联系电话
	private Integer shoppingMallPhone;

	// 无参构造器
	public Shoppingmall() {
	}

	// 有参构造器，进行属性值的初始化
	public Shoppingmall(Long shoppingMallId, String logUrl, String shoppingMallName, String shoppingMallContacts, Integer shoppingMallPhone) {
		this.shoppingMallId = shoppingMallId;
		this.logUrl = logUrl;
		this.shoppingMallName = shoppingMallName;
		this.shoppingMallContacts = shoppingMallContacts;
		this.shoppingMallPhone = shoppingMallPhone;
	}

	// 获取 商城ID 的属性值
	public Long getShoppingMallId() {
		return shoppingMallId;
	}

	// 设置 商城ID 的属性值
	public void setShoppingMallId(Long shoppingMallId) {
		this.shoppingMallId = shoppingMallId;
	}

	// 获取 logo路径 的属性值
	public String getLogUrl() {
		return logUrl;
	}

	// 设置 logo路径 的属性值
	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}

	// 获取 商城名称 的属性值
	public String getShoppingMallName() {
		return shoppingMallName;
	}

	// 设置 商城名称 的属性值
	public void setShoppingMallName(String shoppingMallName) {
		this.shoppingMallName = shoppingMallName;
	}

	// 获取 商城联系人 的属性值
	public String getShoppingMallContacts() {
		return shoppingMallContacts;
	}

	// 设置 商城联系人 的属性值
	public void setShoppingMallContacts(String shoppingMallContacts) {
		this.shoppingMallContacts = shoppingMallContacts;
	}

	// 获取 商城联系电话 的属性值
	public Integer getShoppingMallPhone() {
		return shoppingMallPhone;
	}

	// 设置 商城联系电话 的属性值
	public void setShoppingMallPhone(Integer shoppingMallPhone) {
		this.shoppingMallPhone = shoppingMallPhone;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据
	@Override
	public String toString(){
		return "Shoppingmall {" + 
				", shoppingMallId='" + shoppingMallId + '\'' + 
				", logUrl='" + logUrl + '\'' + 
				", shoppingMallName='" + shoppingMallName + '\'' + 
				", shoppingMallContacts='" + shoppingMallContacts + '\'' + 
				", shoppingMallPhone='" + shoppingMallPhone + '\'' + 
				"}";
	}
}