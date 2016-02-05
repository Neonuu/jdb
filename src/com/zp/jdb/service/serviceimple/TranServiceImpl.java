package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.tranDao;
import com.zp.jdb.entity.Sends_sms;
import com.zp.jdb.service.TranService;
@Service
@Transactional
public class TranServiceImpl implements TranService {
	@Resource
	private tranDao dao;
	public List<Sends_sms> isfindAll(Sends_sms sd) {
		if(sd.getPagenum() == null || sd.getPagenum() <= 0){
			sd.setPagenum(1);
		}
		sd.setStartIndex((sd.getPagenum() - 1) * sd.getPagecount());
		return dao.findAll(sd);
	}
	public int isSelectMsgTotalCount(Sends_sms sd) {
		return dao.selectMsgTotalCount(sd);
	}
	
}
