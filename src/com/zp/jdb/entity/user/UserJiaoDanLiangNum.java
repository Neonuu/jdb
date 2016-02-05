package com.zp.jdb.entity.user;

public class UserJiaoDanLiangNum {
	private String phoneNumber;
	private String user_name;
	private Integer order_id;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "UserJiaoDanLiangNum [phoneNumber=" + phoneNumber
				+ ", user_name=" + user_name + ", order_id=" + order_id + "]";
	}

}
