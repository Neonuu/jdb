package com.zp.jdb.entity;

public class Jdb_systemParam {
	
	private Long id;
	private Double user_scale;
    private Double recommend_scale;
    private Double commission_quota;//佣金可提取比例
    private Byte is_del;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getUser_scale() {
		return user_scale;
	}
	public void setUser_scale(Double userScale) {
		user_scale = userScale;
	}
	public Double getRecommend_scale() {
		return recommend_scale;
	}
	public void setRecommend_scale(Double recommendScale) {
		recommend_scale = recommendScale;
	}
	public Double getCommission_quota() {
		return commission_quota;
	}
	public void setCommission_quota(Double commissionQuota) {
		commission_quota = commissionQuota;
	}
	public Byte getIs_del() {
		return is_del;
	}
	public void setIs_del(Byte isDel) {
		is_del = isDel;
	}
    
	
	
	
	
	
}
