package com.eight.bean;

/**
 * @Author
 * @CreateTime 2021-07-16 10:38:19
 * @Version 1.0
 */
public class BookDetail {
	// 详细id
	private Integer bDetailId;
	// 作者
	private String bAuthor;
	// 出版社
	private String bPublisher;
	// 商品编码
	private String productCore;

	// 无参构造器
	public BookDetail() {
	}

	// 有参构造器，进行属性值的初始化
	public BookDetail(Integer bDetailId, String bAuthor, String bPublisher, String productCore) {
		this.bDetailId = bDetailId;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.productCore = productCore;
	}

	// 获取 详细id 的属性值
	public Integer getBDetailId() {
		return bDetailId;
	}

	// 设置 详细id 的属性值
	public void setBDetailId(Integer bDetailId) {
		this.bDetailId = bDetailId;
	}

	// 获取 作者 的属性值
	public String getBAuthor() {
		return bAuthor;
	}

	// 设置 作者 的属性值
	public void setBAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	// 获取 出版社 的属性值
	public String getBPublisher() {
		return bPublisher;
	}

	// 设置 出版社 的属性值
	public void setBPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
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
		return "BookDetail {" + 
				", bDetailId='" + bDetailId + '\'' + 
				", bAuthor='" + bAuthor + '\'' + 
				", bPublisher='" + bPublisher + '\'' + 
				", productCore='" + productCore + '\'' + 
				"}";
	}
}