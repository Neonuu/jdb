package com.zp.jdb.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户佣金信息表
 * @author Administrator
 *
 */
public class Commission {
	private   Long id;
	private   Long user_id;
	private   BigDecimal balance;
	private   BigDecimal can_use_balance;
	private   BigDecimal total_balance;
	private   Long  recommemd_id;
	private   Byte  id_del;
	private   Date co_time;
	private   BigDecimal recommended_balance;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getCan_use_balance() {
		return can_use_balance;
	}
	public void setCan_use_balance(BigDecimal can_use_balance) {
		this.can_use_balance = can_use_balance;
	}
	public Long getRecommemd_id() {
		return recommemd_id;
	}
	public void setRecommemd_id(Long recommemd_id) {
		this.recommemd_id = recommemd_id;
	}
	public Byte getId_del() {
		return id_del;
	}
	public void setId_del(Byte id_del) {
		this.id_del = id_del;
	}
	public BigDecimal getTotal_balance() {
		return total_balance;
	}
	public void setTotal_balance(BigDecimal total_balance) {
		this.total_balance = total_balance;
	}
	public BigDecimal getRecommended_balance() {
		return recommended_balance;
	}
	public void setRecommended_balance(BigDecimal recommended_balance) {
		this.recommended_balance = recommended_balance;
	}
	public Date getCo_time() {
		return co_time;
	}
	public void setCo_time(Date co_time) {
		this.co_time = co_time;
	}
	@Override
	public String toString() {
		return "Commission [id=" + id + ", user_id=" + user_id + ", balance=" + balance + ", can_use_balance="
				+ can_use_balance + ", total_balance=" + total_balance + ", recommemd_id=" + recommemd_id + ", co_time="+co_time+", id_del="
				+ id_del + "]";
	}
	
	

}
