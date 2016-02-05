package com.zp.jdb.entity;
/**
 * 短信模板类
 * @author 王忠亮，邢照珺
 *
 */
public class Sms_model {
	//模板id
	private int tid;
	//短信模板
	private String sms_msg;
	//短信模板类型
	private String sms_type;
	//是否产生随机数
	private boolean is_random;
	/*
	 * get/set方法
	 */
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getSms_msg() {
		return sms_msg;
	}
	public void setSms_msg(String sms_msg) {
		this.sms_msg = sms_msg;
	}
	public String getSms_type() {
		return sms_type;
	}
	public void setSms_type(String sms_type) {
		this.sms_type = sms_type;
	}
	public boolean isIs_random() {
		return is_random;
	}
	public void setIs_random(boolean is_random) {
		this.is_random = is_random;
	}
}
