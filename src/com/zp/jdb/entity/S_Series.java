package com.zp.jdb.entity;

import java.util.Date;

public class S_Series {
	private int id;
	private int bID;
	private String name;
	private String sContent;
	private String sImg;
	private int pageStyle;
	private boolean isDel;
	private int addUserid;
	private Date addTime;
	private int hit;
	private int ipid;
	private String hotImg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getbID() {
		return bID;
	}
	public void setbID(int bID) {
		this.bID = bID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getsContent() {
		return sContent;
	}
	public void setsContent(String sContent) {
		this.sContent = sContent;
	}
	public String getsImg() {
		return sImg;
	}
	public void setsImg(String sImg) {
		this.sImg = sImg;
	}
	public int getPageStyle() {
		return pageStyle;
	}
	public void setPageStyle(int pageStyle) {
		this.pageStyle = pageStyle;
	}
	public boolean isDel() {
		return isDel;
	}
	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}
	public int getAddUserid() {
		return addUserid;
	}
	public void setAddUserid(int addUserid) {
		this.addUserid = addUserid;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getIpid() {
		return ipid;
	}
	public void setIpid(int ipid) {
		this.ipid = ipid;
	}
	public String getHotImg() {
		return hotImg;
	}
	public void setHotImg(String hotImg) {
		this.hotImg = hotImg;
	}
	
	
	

}
