package com.eight.bean;

import java.sql.Timestamp;

public class ManagerPower {
	// 管理员权限id
	private Long managerPowerId;
	// 管理员权限编码
	private String powerCode;
	// 管理员权限内容
	private String powerContent;
	// 管理员父权限编码
	private String powerParentCode;
	// 权限内容的url地址
	private String powerContentUrl;
	// 最后修改时间
	private Timestamp modifiedTime;

	private ManagerInfo managerInfo;

	// 无参构造器
	public ManagerPower() {
	}

	// 有参构造器，进行属性值的初始化
	public ManagerPower(Long managerPowerId, String powerCode, String powerContentCode, String powerParentCode, Timestamp modifiedTime) {
		this.managerPowerId = managerPowerId;
		this.powerCode = powerCode;
		this.powerContent = powerContentCode;
		this.powerParentCode = powerParentCode;
		this.modifiedTime = modifiedTime;
	}

	// 获取 管理员权限id 的属性值
	public Long getManagerPowerId() {
		return managerPowerId;
	}

	// 设置 管理员权限id 的属性值
	public void setManagerPowerId(Long managerPowerId) {
		this.managerPowerId = managerPowerId;
	}

	// 获取 管理员权限编码 的属性值
	public String getPowerCode() {
		return powerCode;
	}

	// 设置 管理员权限编码 的属性值
	public void setPowerCode(String powerCode) {
		this.powerCode = powerCode;
	}

	// 获取 管理员权限内容 的属性值
	public String getPowerContent() {
		return powerContent;
	}

	// 设置 管理员权限内容 的属性值
	public void setPowerContent(String powerContent) {
		this.powerContent = powerContent;
	}

	// 获取 管理员父权限编码 的属性值
	public String getPowerParentCode() {
		return powerParentCode;
	}

	// 设置 管理员父权限编码 的属性值
	public void setPowerParentCode(String powerParentCode) {
		this.powerParentCode = powerParentCode;
	}

	public String getPowerContentUrl() {
		return powerContentUrl;
	}

	public void setPowerContentUrl(String powerContentUrl) {
		this.powerContentUrl = powerContentUrl;
	}

	// 获取 最后修改时间 的属性值
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	// 设置 最后修改时间 的属性值
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public ManagerInfo getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(ManagerInfo managerInfo) {
		this.managerInfo = managerInfo;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据

	@Override
	public String toString() {
		return "ManagerPower{" +
				"managerPowerId=" + managerPowerId +
				", powerCode='" + powerCode + '\'' +
				", powerContent='" + powerContent + '\'' +
				", powerParentCode='" + powerParentCode + '\'' +
				", powerContentUrl='" + powerContentUrl + '\'' +
				", modifiedTime=" + modifiedTime +
				", managerInfo=" + managerInfo +
				'}';
	}
}