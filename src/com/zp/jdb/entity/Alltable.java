package com.zp.jdb.entity;

import com.zp.jdb.util.ConstantValue;

public class Alltable {
	
	private Integer user_id;
	
	private String user_name;
	
	private String phoneNumber;
	
	private String email;
	
	private int isdel;

	private long group_id;
	
	private String group_name;
	
	private long power_id;
	
	private String power_url;
	
	private String power_name;
	
	private long operate_id;
	
	private String operate_name;
	
	private String operate_url;
	
	private String allgroup_id;
	
	private String allpower_id;
	
	private String alloperate_id;
	
	private Integer is_delete;
	
	private Integer admin;

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
	
	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	public String getAllgroup_id() {
		return allgroup_id;
	}

	public String getOperate_url() {
		return operate_url;
	}

	public void setOperate_url(String operateUrl) {
		operate_url = operateUrl;
	}

	public void setAllgroup_id(String allgroupId) {
		allgroup_id = allgroupId;
	}

	public String getAllpower_id() {
		return allpower_id;
	}

	public void setAllpower_id(String allpowerId) {
		allpower_id = allpowerId;
	}

	public String getAlloperate_id() {
		return alloperate_id;
	}

	public void setAlloperate_id(String alloperateId) {
		alloperate_id = alloperateId;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer isDelete) {
		is_delete = isDelete;
	}

	public int getIsdel() {
		return isdel;
	}

	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer userId) {
		user_id = userId;
	}

	public long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(long groupId) {
		group_id = groupId;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String groupName) {
		group_name = groupName;
	}

	public long getPower_id() {
		return power_id;
	}

	public void setPower_id(long powerId) {
		power_id = powerId;
	}

	public String getPower_url() {
		return power_url;
	}

	public void setPower_url(String powerUrl) {
		power_url = powerUrl;
	}

	public String getPower_name() {
		return power_name;
	}

	public void setPower_name(String powerName) {
		power_name = powerName;
	}

	public long getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(long operateId) {
		operate_id = operateId;
	}

	public String getOperate_name() {
		return operate_name;
	}

	public void setOperate_name(String operateName) {
		operate_name = operateName;
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
