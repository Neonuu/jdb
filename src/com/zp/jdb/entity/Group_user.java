package com.zp.jdb.entity;

public class Group_user {
	
	private Long id;
	
	private Long group_id;
	
	private Long user_id;
	
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

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer isDelete) {
		is_delete = isDelete;
	}

}
