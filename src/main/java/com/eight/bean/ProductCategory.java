package com.eight.bean;

import java.sql.Timestamp;
/**
 * @Author
 * @CreateTime 2021-07-16 10:38:19
 * @Version 1.0
 */
public class ProductCategory {
	// 分类ID
	private Integer categoryId;
	// 分类名称
	private String categoryName;
	// 分类编码
	private String categoryCode;
	// 父分类ID
	private Integer parentId;
	// 分类层级
	private Integer categoryLevel;
	// 分类状态
	private Integer categoryStatus;
	// 最后修改时间
	private Timestamp modifiedTime;

	// 无参构造器
	public ProductCategory() {
	}

	// 有参构造器，进行属性值的初始化
	public ProductCategory(Integer categoryId, String categoryName, String categoryCode, Integer parentId, Integer categoryLevel, Integer categoryStatus, Timestamp modifiedTime) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryCode = categoryCode;
		this.parentId = parentId;
		this.categoryLevel = categoryLevel;
		this.categoryStatus = categoryStatus;
		this.modifiedTime = modifiedTime;
	}

	// 获取 分类ID 的属性值
	public Integer getCategoryId() {
		return categoryId;
	}

	// 设置 分类ID 的属性值
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	// 获取 分类名称 的属性值
	public String getCategoryName() {
		return categoryName;
	}

	// 设置 分类名称 的属性值
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	// 获取 分类编码 的属性值
	public String getCategoryCode() {
		return categoryCode;
	}

	// 设置 分类编码 的属性值
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	// 获取 父分类ID 的属性值
	public Integer getParentId() {
		return parentId;
	}

	// 设置 父分类ID 的属性值
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	// 获取 分类层级 的属性值
	public Integer getCategoryLevel() {
		return categoryLevel;
	}

	// 设置 分类层级 的属性值
	public void setCategoryLevel(Integer categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	// 获取 分类状态 的属性值
	public Integer getCategoryStatus() {
		return categoryStatus;
	}

	// 设置 分类状态 的属性值
	public void setCategoryStatus(Integer categoryStatus) {
		this.categoryStatus = categoryStatus;
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
		return "ProductCategory {" + 
				", categoryId='" + categoryId + '\'' + 
				", categoryName='" + categoryName + '\'' + 
				", categoryCode='" + categoryCode + '\'' + 
				", parentId='" + parentId + '\'' + 
				", categoryLevel='" + categoryLevel + '\'' + 
				", categoryStatus='" + categoryStatus + '\'' + 
				", modifiedTime='" + modifiedTime + '\'' + 
				"}";
	}
}