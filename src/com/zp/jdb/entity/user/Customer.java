package com.zp.jdb.entity.user;

public class Customer {
	private Integer customer_id;
	private String customer_name;
	private String customer_cid;
	private Integer user_id;
	private Integer isdel;

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_cid() {
		return customer_cid;
	}

	public void setCustomer_cid(String customer_cid) {
		this.customer_cid = customer_cid;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name="
				+ customer_name + ", customer_cid=" + customer_cid
				+ ", user_id=" + user_id + ", isdel=" + isdel + "]";
	}

}
