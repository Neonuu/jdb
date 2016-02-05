package com.zp.jdb.entity;

import java.util.Date;

public class Change_system_param_record {
	private Long id;
	private Double old_user_scale;
	private Double new_user_scale;
	private Double old_recommend_scale;
	private Double new_recommend_scale;
	private Double old_commission_quota;
	private Double new_commission_quota;
	private Date add_time;
	private Long auditer_id;
	private Byte is_del;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getOld_user_scale() {
		return old_user_scale;
	}
	public void setOld_user_scale(Double oldUserScale) {
		old_user_scale = oldUserScale;
	}
	public Double getNew_user_scale() {
		return new_user_scale;
	}
	public void setNew_user_scale(Double newUserScale) {
		new_user_scale = newUserScale;
	}
	public Double getOld_recommend_scale() {
		return old_recommend_scale;
	}
	public void setOld_recommend_scale(Double oldRecommendScale) {
		old_recommend_scale = oldRecommendScale;
	}
	public Double getNew_recommend_scale() {
		return new_recommend_scale;
	}
	public void setNew_recommend_scale(Double newRecommendScale) {
		new_recommend_scale = newRecommendScale;
	}
	public Double getOld_commission_quota() {
		return old_commission_quota;
	}
	public void setOld_commission_quota(Double oldCommissionQuota) {
		old_commission_quota = oldCommissionQuota;
	}
	public Double getNew_commission_quota() {
		return new_commission_quota;
	}
	public void setNew_commission_quota(Double newCommissionQuota) {
		new_commission_quota = newCommissionQuota;
	}
	
	
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date addTime) {
		add_time = addTime;
	}
	public Long getAuditer_id() {
		return auditer_id;
	}
	public void setAuditer_id(Long auditerId) {
		auditer_id = auditerId;
	}
	public Byte getIs_del() {
		return is_del;
	}
	public void setIs_del(Byte isDel) {
		is_del = isDel;
	}
	@Override
	public String toString() {
		return "Change_system_param_record [add_date=" + add_time
				+ ", auditer_id=" + auditer_id + ", id=" + id + ", is_del="
				+ is_del + ", new_commission_quota=" + new_commission_quota
				+ ", new_recommend_scale=" + new_recommend_scale
				+ ", new_user_scale=" + new_user_scale
				+ ", old_commission_quota=" + old_commission_quota
				+ ", old_recommend_scale=" + old_recommend_scale
				+ ", old_user_scale=" + old_user_scale + "]";
	}
	
	
	

}
