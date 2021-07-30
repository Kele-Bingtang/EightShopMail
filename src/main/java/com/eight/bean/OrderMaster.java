package com.eight.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class OrderMaster {
	// 订单ID
	private String orderId;
	// 订单编号 yyyymmddnnnnnnnn
	private BigInteger orderSn;
	// 下单人ID
	private Long userId;
	// 收货人姓名
	private String shippingUser;
	// 省
	private Integer province;
	// 市
	private Integer city;
	// 区
	private Integer district;
	// 地址
	private String address;
	// 支付方式：1余额，2支付宝，3微信
	private Integer paymentMethod;
	// 订单金额
	private BigDecimal orderMoney;
	// 优惠金额
	private BigDecimal districtMoney;
	// 运费金额
	private BigDecimal shippingMoney;
	// 支付金额
	private BigDecimal paymentMoney;
	// 商城名称
	private String shoppingMallName;
	// 下单时间
	private Timestamp createTime;
	// 发货时间
	private Timestamp shippingTime;
	// 支付时间
	private Timestamp payTime;
	// 收货时间
	private Timestamp receiveTime;
	// 订单状态，0未处理，1发货，3派送
	private Integer orderStatus;
	// 订单积分
	private Long orderPoint;
	// 最后修改时间
	private Timestamp modifiedTime;

	private ProductInfo productInfo;

	private ProductPicInfo productPicInfo;

	@Override
	public String toString() {
		return "OrderMaster{" +
				"orderId='" + orderId + '\'' +
				", orderSn=" + orderSn +
				", userId=" + userId +
				", shippingUser='" + shippingUser + '\'' +
				", province=" + province +
				", city=" + city +
				", district=" + district +
				", address='" + address + '\'' +
				", paymentMethod=" + paymentMethod +
				", orderMoney=" + orderMoney +
				", districtMoney=" + districtMoney +
				", shippingMoney=" + shippingMoney +
				", paymentMoney=" + paymentMoney +
				", shoppingMallName='" + shoppingMallName + '\'' +
				", createTime=" + createTime +
				", shippingTime=" + shippingTime +
				", payTime=" + payTime +
				", receiveTime=" + receiveTime +
				", orderStatus=" + orderStatus +
				", orderPoint=" + orderPoint +
				", modifiedTime=" + modifiedTime +
				", productInfo=" + productInfo +
				", productPicInfo=" + productPicInfo +
				'}';
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public ProductPicInfo getProductPicInfo() {
		return productPicInfo;
	}

	public void setProductPicInfo(ProductPicInfo productPicInfo) {
		this.productPicInfo = productPicInfo;
	}

	public OrderMaster(String orderId, BigInteger orderSn, Long userId, String shippingUser, Integer province, Integer city, Integer district, String address, Integer paymentMethod, BigDecimal orderMoney, BigDecimal districtMoney, BigDecimal shippingMoney, BigDecimal paymentMoney, String shoppingMallName, Timestamp createTime, Timestamp shippingTime, Timestamp payTime, Timestamp receiveTime, Integer orderStatus, Long orderPoint, Timestamp modifiedTime, ProductInfo productInfo, ProductPicInfo productPicInfo) {
		this.orderId = orderId;
		this.orderSn = orderSn;
		this.userId = userId;
		this.shippingUser = shippingUser;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.orderMoney = orderMoney;
		this.districtMoney = districtMoney;
		this.shippingMoney = shippingMoney;
		this.paymentMoney = paymentMoney;
		this.shoppingMallName = shoppingMallName;
		this.createTime = createTime;
		this.shippingTime = shippingTime;
		this.payTime = payTime;
		this.receiveTime = receiveTime;
		this.orderStatus = orderStatus;
		this.orderPoint = orderPoint;
		this.modifiedTime = modifiedTime;
		this.productInfo = productInfo;
		this.productPicInfo = productPicInfo;
	}

	// 无参构造器
	public OrderMaster() {
	}


	// 获取 订单ID 的属性值
	public String getOrderId() {
		return orderId;
	}

	// 设置 订单ID 的属性值
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	// 获取 订单编号 yyyymmddnnnnnnnn 的属性值
	public BigInteger getOrderSn() {
		return orderSn;
	}

	// 设置 订单编号 yyyymmddnnnnnnnn 的属性值
	public void setOrderSn(BigInteger orderSn) {
		this.orderSn = orderSn;
	}

	// 获取 下单人ID 的属性值
	public Long getUserId() {
		return userId;
	}

	// 设置 下单人ID 的属性值
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// 获取 收货人姓名 的属性值
	public String getShippingUser() {
		return shippingUser;
	}

	// 设置 收货人姓名 的属性值
	public void setShippingUser(String shippingUser) {
		this.shippingUser = shippingUser;
	}

	// 获取 省 的属性值
	public Integer getProvince() {
		return province;
	}

	// 设置 省 的属性值
	public void setProvince(Integer province) {
		this.province = province;
	}

	// 获取 市 的属性值
	public Integer getCity() {
		return city;
	}

	// 设置 市 的属性值
	public void setCity(Integer city) {
		this.city = city;
	}

	// 获取 区 的属性值
	public Integer getDistrict() {
		return district;
	}

	// 设置 区 的属性值
	public void setDistrict(Integer district) {
		this.district = district;
	}

	// 获取 地址 的属性值
	public String getAddress() {
		return address;
	}

	// 设置 地址 的属性值
	public void setAddress(String address) {
		this.address = address;
	}

	// 获取 支付方式：1余额，2支付宝，3微信 的属性值
	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	// 设置 支付方式：1余额，2支付宝，3微信 的属性值
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	// 获取 订单金额 的属性值
	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	// 设置 订单金额 的属性值
	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	// 获取 优惠金额 的属性值
	public BigDecimal getDistrictMoney() {
		return districtMoney;
	}

	// 设置 优惠金额 的属性值
	public void setDistrictMoney(BigDecimal districtMoney) {
		this.districtMoney = districtMoney;
	}

	// 获取 运费金额 的属性值
	public BigDecimal getShippingMoney() {
		return shippingMoney;
	}

	// 设置 运费金额 的属性值
	public void setShippingMoney(BigDecimal shippingMoney) {
		this.shippingMoney = shippingMoney;
	}

	// 获取 支付金额 的属性值
	public BigDecimal getPaymentMoney() {
		return paymentMoney;
	}

	// 设置 支付金额 的属性值
	public void setPaymentMoney(BigDecimal paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	// 获取 商城名称 的属性值
	public String getShoppingMallName() {
		return shoppingMallName;
	}

	// 设置 商城名称 的属性值
	public void setShoppingMallName(String shoppingMallName) {
		this.shoppingMallName = shoppingMallName;
	}

	// 获取 下单时间 的属性值
	public Timestamp getCreateTime() {
		return createTime;
	}

	// 设置 下单时间 的属性值
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	// 获取 发货时间 的属性值
	public Timestamp getShippingTime() {
		return shippingTime;
	}

	// 设置 发货时间 的属性值
	public void setShippingTime(Timestamp shippingTime) {
		this.shippingTime = shippingTime;
	}

	// 获取 支付时间 的属性值
	public Timestamp getPayTime() {
		return payTime;
	}

	// 设置 支付时间 的属性值
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	// 获取 收货时间 的属性值
	public Timestamp getReceiveTime() {
		return receiveTime;
	}

	// 设置 收货时间 的属性值
	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	// 获取 订单状态，0未处理，1发货，3派送 的属性值
	public Integer getOrderStatus() {
		return orderStatus;
	}

	// 设置 订单状态，0未处理，1发货，3派送 的属性值
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	// 获取 订单积分 的属性值
	public Long getOrderPoint() {
		return orderPoint;
	}

	// 设置 订单积分 的属性值
	public void setOrderPoint(Long orderPoint) {
		this.orderPoint = orderPoint;
	}

	// 获取 最后修改时间 的属性值
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	// 设置 最后修改时间 的属性值
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}