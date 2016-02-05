package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.Sms_msg;


public interface MsgService {
	
	public List<Sms_msg> isFindAll(Sms_msg ata);
	
	public int isSelectMsgTotalCount(Sms_msg ata);
	
	public void isinsertsms_msg(Sms_msg ata);
	
	public void isdeletesms_msg(int id);
	
	public Sms_msg isfindbytid(int id);
	public void isupdatesms_msg(Sms_msg ata);
	public List<Sms_msg> isFindAllInfo();
	
}
