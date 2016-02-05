package com.zp.jdb.service.serviceimple;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.System_JournalService;

@Service
public class System_JournalServiceImpl implements System_JournalService{
    
	@Resource
	private System_JournalDao sjDao;
	@Transactional
	public void addJournal(System_Journal sj) throws Exception{
		sjDao.addJournal(sj);
		
	}

	
	public List<System_Journal> findJournalsByLimit(Map<String, Object> paramMap) {
		List<System_Journal> resList=sjDao.findJournalsByLimit(paramMap);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(System_Journal sj:resList){
			String strDate=sdf.format(sj.getDate());
			sj.setStrDate(strDate);
		}
		return resList;
	}

	
	public int findJournalsAll(Map<String, Object> paramMap) {
		int page=sjDao.findJournalsAll(paramMap);
		return page;
	}
}
