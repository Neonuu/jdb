package com.zp.jdb.entity;

import java.util.Date;

public class Brand {
	private int Id;
	private String BName;
	private String BImg;
	private String BContent;
	private boolean IsDel;
	private int AddUserid;
	private Date AddTime;
	private int hit;
	private String url;
	private int ipid;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBName() {
		return BName;
	}
	public void setBName(String bName) {
		BName = bName;
	}
	public String getBImg() {
		return BImg;
	}
	public void setBImg(String bImg) {
		BImg = bImg;
	}
	public String getBContent() {
		return BContent;
	}
	public void setBContent(String bContent) {
		BContent = bContent;
	}
	public boolean isIsDel() {
		return IsDel;
	}
	public void setIsDel(boolean isDel) {
		IsDel = isDel;
	}
	public int getAddUserid() {
		return AddUserid;
	}
	public void setAddUserid(int addUserid) {
		AddUserid = addUserid;
	}
	public Date getAddTime() {
		return AddTime;
	}
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIpid() {
		return ipid;
	}
	public void setIpid(int ipid) {
		this.ipid = ipid;
	}
	
}
