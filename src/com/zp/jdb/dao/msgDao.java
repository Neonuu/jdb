package com.zp.jdb.dao;

import java.util.List;
import com.zp.jdb.entity.Sms_msg;

public interface msgDao {
	/**
	 * 查询模板
	 * @param ata 实体类
	 * @return
	 */
	public List<Sms_msg> findAll(Sms_msg ata);
	
	/**
	 * 获取总页数
	 * @param ata 实体类
	 * @return
	 */
	public int selectMsgTotalCount(Sms_msg ata);
	
	/**
	 * 增加模板
	 * @param ata 实体类
	 */
	public void insertsms_msg(Sms_msg ata);
	
	/**
	 * 删除目标那
	 * @param tid 表id
	 */
	public void deletesms_msg(int tid);
	
	/**
	 * 根据id进行查询
	 * @param id 
	 * @return
	 */
	public Sms_msg findbytid(int id);
	
	/**
	 * 修改模板
	 * @param ata
	 */
	public void updatesms_msg(Sms_msg ata);
	
	/**
	 * 获取模板表状态列
	 * @return
	 */
	public List<Sms_msg> findAllInfo();
}





