package com.zp.jdb.entity;

public class Group_power {
	
	private Long id;
	
	private Long group_id;
	
	private Long power_id;
	
	private Integer is_delete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Long groupId) {
		group_id = groupId;
	}

	public Long getPower_id() {
		return power_id;
	}

	public void setPower_id(Long powerId) {
		power_id = powerId;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer isDelete) {
		is_delete = isDelete;
	}

}
