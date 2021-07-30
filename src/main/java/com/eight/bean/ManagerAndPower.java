package com.eight.bean;

import java.sql.Timestamp;

public class ManagerAndPower {
	// 管理员和权限ID
	private Long managerAndPowerId;
	// 管理员编码
	private String managerCode;
	// 管理员权限编码
	private String powerCode;
	// 最后修改时间
	private Timestamp modifiedTime;

	// 无参构造器
	public ManagerAndPower() {
	}

	// 有参构造器，进行属性值的初始化
	public ManagerAndPower(Long managerAndPowerId, String managerCode, String powerCode, Timestamp modifiedTime) {
		this.managerAndPowerId = managerAndPowerId;
		this.managerCode = managerCode;
		this.powerCode = powerCode;
		this.modifiedTime = modifiedTime;
	}

	// 获取 管理员和权限ID 的属性值
	public Long getManagerAndPowerId() {
		return managerAndPowerId;
	}

	// 设置 管理员和权限ID 的属性值
	public void setManagerAndPowerId(Long managerAndPowerId) {
		this.managerAndPowerId = managerAndPowerId;
	}

	// 获取 管理员编码 的属性值
	public String getManagerCode() {
		return managerCode;
	}

	// 设置 管理员编码 的属性值
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	// 获取 管理员权限编码 的属性值
	public String getPowerCode() {
		return powerCode;
	}

	// 设置 管理员权限编码 的属性值
	public void setPowerCode(String powerCode) {
		this.powerCode = powerCode;
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
		return "ManagerAndPower {" + 
				", managerAndPowerId='" + managerAndPowerId + '\'' + 
				", managerCode='" + managerCode + '\'' + 
				", powerCode='" + powerCode + '\'' + 
				", modifiedTime='" + modifiedTime + '\'' + 
				"}";
	}
}