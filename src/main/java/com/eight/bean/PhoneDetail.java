package com.eight.bean;

import java.math.BigDecimal;
/**
 * @Author
 * @CreateTime 2021-07-16 10:38:19
 * @Version 1.0
 */
public class PhoneDetail {
	// 详细信息ID
	private Integer pDetailId;
	// 高度
	private BigDecimal pHeight;
	// 宽度
	private BigDecimal pWidth;
	// 尺寸
	private BigDecimal pSize;
	// 重量
	private BigDecimal pWeight;
	// 机身颜色
	private String pColor;
	// 套餐类型
	private String pMeal;
	// 版本
	private String pVersion;
	// 内存容量
	private String pCapacity;
	// 商品编码
	private String productCore;

	// 无参构造器
	public PhoneDetail() {
	}

	// 有参构造器，进行属性值的初始化
	public PhoneDetail(Integer pDetailId, BigDecimal pHeight, BigDecimal pWidth, BigDecimal pSize, BigDecimal pWeight, String pColor, String pMeal, String pVersion, String pCapacity, String productCore) {
		this.pDetailId = pDetailId;
		this.pHeight = pHeight;
		this.pWidth = pWidth;
		this.pSize = pSize;
		this.pWeight = pWeight;
		this.pColor = pColor;
		this.pMeal = pMeal;
		this.pVersion = pVersion;
		this.pCapacity = pCapacity;
		this.productCore = productCore;
	}

	// 获取 详细信息ID 的属性值
	public Integer getPDetailId() {
		return pDetailId;
	}

	// 设置 详细信息ID 的属性值
	public void setPDetailId(Integer pDetailId) {
		this.pDetailId = pDetailId;
	}

	// 获取 高度 的属性值
	public BigDecimal getPHeight() {
		return pHeight;
	}

	// 设置 高度 的属性值
	public void setPHeight(BigDecimal pHeight) {
		this.pHeight = pHeight;
	}

	// 获取 宽度 的属性值
	public BigDecimal getPWidth() {
		return pWidth;
	}

	// 设置 宽度 的属性值
	public void setPWidth(BigDecimal pWidth) {
		this.pWidth = pWidth;
	}

	// 获取 尺寸 的属性值
	public BigDecimal getPSize() {
		return pSize;
	}

	// 设置 尺寸 的属性值
	public void setPSize(BigDecimal pSize) {
		this.pSize = pSize;
	}

	// 获取 重量 的属性值
	public BigDecimal getPWeight() {
		return pWeight;
	}

	// 设置 重量 的属性值
	public void setPWeight(BigDecimal pWeight) {
		this.pWeight = pWeight;
	}

	// 获取 机身颜色 的属性值
	public String getPColor() {
		return pColor;
	}

	// 设置 机身颜色 的属性值
	public void setPColor(String pColor) {
		this.pColor = pColor;
	}

	// 获取 套餐类型 的属性值
	public String getPMeal() {
		return pMeal;
	}

	// 设置 套餐类型 的属性值
	public void setPMeal(String pMeal) {
		this.pMeal = pMeal;
	}

	// 获取 版本 的属性值
	public String getPVersion() {
		return pVersion;
	}

	// 设置 版本 的属性值
	public void setPVersion(String pVersion) {
		this.pVersion = pVersion;
	}

	// 获取 内存容量 的属性值
	public String getPCapacity() {
		return pCapacity;
	}

	// 设置 内存容量 的属性值
	public void setPCapacity(String pCapacity) {
		this.pCapacity = pCapacity;
	}

	// 获取 商品编码 的属性值
	public String getProductCore() {
		return productCore;
	}

	// 设置 商品编码 的属性值
	public void setProductCore(String productCore) {
		this.productCore = productCore;
	}

	// 重写toString方法，使用该方法可以在控制台打印属性的数据
	@Override
	public String toString(){
		return "PhoneDetail {" + 
				", pDetailId='" + pDetailId + '\'' + 
				", pHeight='" + pHeight + '\'' + 
				", pWidth='" + pWidth + '\'' + 
				", pSize='" + pSize + '\'' + 
				", pWeight='" + pWeight + '\'' + 
				", pColor='" + pColor + '\'' + 
				", pMeal='" + pMeal + '\'' + 
				", pVersion='" + pVersion + '\'' + 
				", pCapacity='" + pCapacity + '\'' + 
				", productCore='" + productCore + '\'' + 
				"}";
	}
}