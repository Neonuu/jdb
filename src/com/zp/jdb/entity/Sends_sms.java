package com.zp.jdb.entity;

import java.util.Date;

import com.zp.jdb.util.pageValue;

/**
 * 短信实体类
 * 
 * @author 邢昭君 王忠亮
 *
 */
public class Sends_sms {
	// 发送短信id
	private int tran_id;
	// 发送短信主叫
	private String callback;
	// 发送短信被叫
	private String phone_num;
	// 发送短信实际内容
	private String sms_msg;
	// 发送短信时间
	private String send_time;
	// 发送短信的状态
    private int stauts;
	// 发送短信用户
	private String users;
	// 短信类型
	private String info;
	
	//页码
	private Integer pagenum;
		
	//起始下标
	private Integer startIndex;
		
	//每页几条
	private Integer pagecount = pageValue.PAGE_COUNT;
		
	//总条数
	private Integer totalCount;
		
	//最大页码
	private Integer maxpage;
	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public int getTran_id() {
		return tran_id;
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getSms_msg() {
		return sms_msg;
	}

	public void setSms_msg(String sms_msg) {
		this.sms_msg = sms_msg;
	}
    

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public int getStauts() {
		return stauts;
	}

	public void setStauts(int stauts) {
		this.stauts = stauts;
	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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
