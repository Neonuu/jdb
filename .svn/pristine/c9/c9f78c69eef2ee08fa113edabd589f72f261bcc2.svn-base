package com.zp.jdb.dao;

import java.util.List;
import com.zp.jdb.entity.Alltable;


public interface AlltableDao {
	
	/**
	 * 查询管理组与权限的关系。
	 * @return
	 */
	public List<Alltable> selectGroupAndPower();
	/**
	 * 查询管理组表的信息。
	 * @return
	 */
	public List<Alltable> selectGroup();
	/**
	 * 查询id是否在user_cando表内。
	 * @param ata
	 * @return
	 */
	public int selectID(Alltable ata);
	/**
	 * 查询登录的id拥有的权限。
	 * @param ata
	 * @return
	 */
	public String selectAllpower(Alltable ata);
	/**
	 * 查询登录的id拥有的操作。
	 * @param ata
	 * @return
	 */
	public String selectAlloperate(Alltable ata);
	/**
	 * 查询登录id的姓名。
	 * @param ata
	 * @return
	 */
	public String selectUser_name(Alltable ata);
	/**
	 * 查询登录用户所属组。
	 * @param id
	 * @return
	 */
	public String selectInGroup(String id);
	/**
	 * 查询登录用户的admin。
	 * @param ata
	 * @return
	 */
	public int selectAdmin(Alltable ata);
	/**
	 * 查询在选中权限id下的所有操作。
	 * @param ata
	 * @return
	 */
	public List<Alltable> selectOperateInPower(Alltable ata);
	/**
	 * 查询管理员个人信息。
	 * @param ata
	 * @return
	 */
	public List<Alltable> selectAdministrator(Alltable ata);
	/**
	 * 查询管理员总个数。
	 * @param ata
	 * @return
	 */
	public int selectAdminTotalCount(Alltable ata);
	/**
	 * 将管理员is_delete列“0”变为“1”。
	 * @param ata
	 */
	public void deleteAdministrator(Alltable ata);
	/**
	 * 查询普通用户的个人信息。
	 * @param ata
	 * @return
	 */
	public List<Alltable> selectPutongUser(Alltable ata);
	/**
	 * 查询所有用户
	 * @param ata
	 * @return
	 */
	public List<Alltable> selectAllUser(Alltable ata);
	/**
	 * 查询普通用户的总个数。
	 * @param ata
	 * @return
	 */
	public int selectAdminTotalCount2(Alltable ata);
	/**
	 * 查询所有用户的总个数。
	 * @param ata
	 * @return
	 */
	public int selectAdminTotalCount3(Alltable ata);
	/**
	 * 查询管理组id，name。
	 * @return
	 */
	public List<Alltable> selectGroupID();
	/**
	 * 查询权限id，name。
	 * @return
	 */
	public List<Alltable> selectPowerID();
	/**
	 * 查询操作id，name。
	 * @return
	 */
	public List<Alltable> selectOperateID();
	/**
	 * 查询管理组名为“管理员管理组”的id。
	 * @return
	 */
	public long selectGuanliyuanguanliID();
	/**
	 * 查询机构管理组内的所有权限。
	 * @param id
	 * @return
	 */
	public List<Alltable> selectJigouguanliPowerID(long id);
	/**
	 * 查询机构管理组内的所有操作。
	 * @param id
	 * @return
	 */
	public List<Alltable> selectJigouguanliOperateID(long id);
	/**
	 * 增加拥有管理员所有权限及操作的管理员
	 * @param ata
	 */
	public void insertAllAdmin(Alltable ata);
	/**
	 * 增加机构管理员所用权限及操作的机构管理员。
	 * @param ata
	 */
	public void insertJigouAdmin(Alltable ata);
	/**
	 * 查询所以权限及其对应的操作。
	 * @return
	 */
	public List<Alltable> selectPowerAndOperate();
	/**
	 * 查询被选中id的用户拥有的权限。
	 * @param ata
	 * @return
	 */
	public String selectAdminPower(Alltable ata);
	/**
	 * 查询被选中id的用户拥有的操作。
	 * @param ata
	 * @return
	 */
	public String selectAdminOperate(Alltable ata);
	/**
	 * 更新被选中id的用户的权限及操作。
	 * @param ata
	 */
	public void updatePower(Alltable ata);
	/**
	 * 查询被选中id的用户的管理等级（1，系统管理员。2，管理员。3，机构管理员。）。
	 * @param ata
	 * @return
	 */
	public int selectXuanAdmin(Alltable ata);
	
	
	public String selectjigouIDbyUserID(int user_id);
}