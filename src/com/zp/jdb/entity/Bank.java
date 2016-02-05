package com.zp.jdb.entity;

import java.util.Date;

public class Bank {
	private Long id;
	private Long user_id;
	private String true_name;
	private String bank_name;
	private String bank_type;
	private String bank_number;
	private String tel;
	private Date add_time;
	private Byte is_del;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}
	public String getBank_number() {
		return bank_number;
	}
	public void setBank_number(String bank_number) {
		this.bank_number = bank_number;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Byte getIs_del() {
		return is_del;
	}
	public void setIs_del(Byte is_del) {
		this.is_del = is_del;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	
    
	
}
