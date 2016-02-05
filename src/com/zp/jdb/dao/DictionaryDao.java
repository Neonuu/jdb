package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.Dictionary;

public interface DictionaryDao {
	/**
	 * 根据parent_id 查询数据（查询省或者市）
	 * @param parent_id
	 * @return
	 */
	public List<Dictionary> findByParentId(int parent_id);
	
	/**
	 * 根据省份名字查询其id
	 * @param provinceName  省份的名字
	 * @return
	 */
	public  int findById(String provinceName);
	

}
