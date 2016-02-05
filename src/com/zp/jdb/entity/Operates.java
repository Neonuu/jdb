package com.zp.jdb.entity;

public class Operates {
	
	private Long id;
	
	private Long operate_id;
	
	private String operate_name;
	
	private String operate_url;
	
	private Integer is_delete;

	public Long getId() {
		return id;
	}

	public String getOperate_url() {
		return operate_url;
	}

	public void setOperate_url(String operateUrl) {
		operate_url = operateUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOperate_id() {
		return operate_id;
	}

	public void setOperate_id(Long operateId) {
		operate_id = operateId;
	}

	public String getOperate_name() {
		return operate_name;
	}

	public void setOperate_name(String operateName) {
		operate_name = operateName;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer isDelete) {
		is_delete = isDelete;
	}

}
