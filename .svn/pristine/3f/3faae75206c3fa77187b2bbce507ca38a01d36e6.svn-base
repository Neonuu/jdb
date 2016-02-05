package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.msgDao;
import com.zp.jdb.entity.Sms_msg;
import com.zp.jdb.service.MsgService;

@Service
@Transactional
public class MsgServiceImpl implements MsgService{
	@Resource
	private msgDao dao;
	public List<Sms_msg> isFindAll(Sms_msg ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.findAll(ata);
	}
	
	public int isSelectMsgTotalCount(Sms_msg ata) {
		return dao.selectMsgTotalCount(ata);
	}

	public void isinsertsms_msg(Sms_msg ata) {
		dao.insertsms_msg(ata);
	}

	public void isdeletesms_msg(int tid) {
		dao.deletesms_msg(tid);
	}

	public void isupdatesms_msg(Sms_msg ata) {
		dao.updatesms_msg(ata);
		
	}

	public Sms_msg isfindbytid(int id) {
		return dao.findbytid(id);
	}

	public List<Sms_msg> isFindAllInfo() {
		return dao.findAllInfo();
	}



}
