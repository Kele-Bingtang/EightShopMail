package com.eight.bean;

import java.sql.Timestamp;
import java.util.List;

public class ManagerInfo {
	// 管理员id
	private Long managerId;
	// 管理员用户名
	private String managerUsername;
	// 管理员密码
	private String managerPassword;
	// 管理员编码
	private String managerCode;
	// 管理员职位
	private String managerJob;
	// 管理员最后登录时间
	private Timestamp managerLoginTime;

	private List<ManagerPower> managerPowers;

	// 无参构造器
	public ManagerInfo() {
	}

	// 有参构造器，进行属性值的初始化
	public ManagerInfo(Long managerId, String managerUsername, String managerPassword, String managerCode, String managerJob, Timestamp managerLoginTime) {
		this.managerId = managerId;
		this.managerUsername = managerUsername;
		this.managerPassword = managerPassword;
		this.managerCode = managerCode;
		this.managerJob = managerJob;
		this.managerLoginTime = managerLoginTime;
	}

	// 获取 管理员id 的属性值
	public Long getManagerId() {
		return managerId;
	}

	// 设置 管理员id 的属性值
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	// 获取 管理员用户名 的属性值
	public String getManagerUsername() {
		return managerUsername;
	}

	// 设置 管理员用户名 的属性值
	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	// 获取 管理员密码 的属性值
	public String getManagerPassword() {
		return managerPassword;
	}

	// 设置 管理员密码 的属性值
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	// 获取 管理员编码 的属性值
	public String getManagerCode() {
		return managerCode;
	}

	// 设置 管理员编码 的属性值
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	// 获取 管理员职位 的属性值
	public String getManagerJob() {
		return managerJob;
	}

	// 设置 管理员职位 的属性值
	public void setManagerJob(String managerJob) {
		this.managerJob = managerJob;
	}

	// 获取 管理员最后登录时间 的属性值
	public Timestamp getManagerLoginTime() {
		return managerLoginTime;
	}

	// 设置 管理员最后登录时间 的属性值
	public void setManagerLoginTime(Timestamp managerLoginTime) {
		this.managerLoginTime = managerLoginTime;
	}


	public List<ManagerPower> getManagerPowers() {
		return managerPowers;
	}

	public void setManagerPowers(List<ManagerPower> managerPowers) {
		this.managerPowers = managerPowers;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据

	@Override
	public String toString() {
		return "ManagerInfo{" +
				"managerId=" + managerId +
				", managerUsername='" + managerUsername + '\'' +
				", managerPassword='" + managerPassword + '\'' +
				", managerCode='" + managerCode + '\'' +
				", managerJob='" + managerJob + '\'' +
				", managerLoginTime=" + managerLoginTime +
				", managerPowers=" + managerPowers +
				'}';
	}
}