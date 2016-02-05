package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Auditing_order_record;

public interface Auditing_order_recordDao {
	
	
	public void addRecord(Auditing_order_record aor);

	public List<Auditing_order_record> findAllByLimit(Map<String,Object> map);
	
	public int findAll(Map<String,Object> map);
	
}
