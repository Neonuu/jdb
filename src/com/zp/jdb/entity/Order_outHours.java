package com.zp.jdb.entity;

import java.util.Date;

/**
 * 72小时外订单信息表
 * @author Administrator
 *
 */
public class Order_outHours {

	private Long id;
	private Long user_id;
	private String order_number;
	private String user_identity;
	private String product;
	private String true_name;
	private String user_idCardNumber;
	private String tel_number;
	private String province;
	private String city;
	private Date add_time;
	private Integer status;
	private Integer is_del;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long userId) {
		user_id = userId;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String orderNumber) {
		order_number = orderNumber;
	}
	public String getUser_identity() {
		return user_identity;
	}
	public void setUser_identity(String userIdentity) {
		user_identity = userIdentity;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String trueName) {
		true_name = trueName;
	}
	public String getUser_idCardNumber() {
		return user_idCardNumber;
	}
	public void setUser_idCardNumber(String userIdCardNumber) {
		user_idCardNumber = userIdCardNumber;
	}
	public String getTel_number() {
		return tel_number;
	}
	public void setTel_number(String telNumber) {
		tel_number = telNumber;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date addTime) {
		add_time = addTime;
	}
	public Integer getIs_del() {
		return is_del;
	}
	public void setIs_del(Integer isDel) {
		is_del = isDel;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
