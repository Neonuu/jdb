package com.zp.jdb.entity;


import com.zp.jdb.util.ConstantValue;

public class CustomerO {
	
	public Integer id;
	
	public String customer_name;
	
	public String passport;
	
	public String add_time;
	
	public String company_info;
	
	public String house_info;
	
	public String car_info;
	
	public String email;
	
	public String img;
	
	public String phone;
	
	public Integer user_id;
	
	private int isdel;
	
	//页码
	private Integer pagenum;
	
	//起始下标
	private Integer startIndex;
	
	//每页几条
	private Integer pagecount = ConstantValue.PAGE_COUNT;
	
	//总条数
	private Integer totalCount;
	
	//最大页码
	private Integer maxpage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public String getCompany_info() {
		return company_info;
	}

	public void setCompany_info(String company_info) {
		this.company_info = company_info;
	}

	public String getHouse_info() {
		return house_info;
	}

	public void setHouse_info(String house_info) {
		this.house_info = house_info;
	}

	public String getCar_info() {
		return car_info;
	}

	public void setCar_info(String car_info) {
		this.car_info = car_info;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public Integer getPagenum() {
		return pagenum;
	}

	public void setPagenum(Integer pagenum) {
		this.pagenum = pagenum;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPagecount() {
		return pagecount;
	}

	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}
}
