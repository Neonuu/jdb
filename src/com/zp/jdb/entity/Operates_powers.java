package com.zp.jdb.entity;

public class Operates_powers {
	
	private Long id;
	
	private Long power_id;
	
	private Long operate_id;
	
	private int is_delete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPower_id() {
		return power_id;
	}

	public void setPower_id(Long powerId) {
		power_id = powerId;
	}

	public Long getOperates_id() {
		return operate_id;
	}

	public void setOperates_id(Long operatesId) {
		operate_id = operatesId;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int isDelete) {
		is_delete = isDelete;
	}

}
