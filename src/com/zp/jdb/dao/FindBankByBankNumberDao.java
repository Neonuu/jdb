package com.zp.jdb.dao;

import java.util.Map;

import com.zp.jdb.entity.Bank;

public interface FindBankByBankNumberDao {
	
	public Bank findBankByBankNumber(Map<String, Object> map);

}
