package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;


public interface AdminService {
	
	public List<Alltable> isSelectGroupAndPower();
	
	public List<Alltable> isSelectGroup();
	
	public int isSelectID(Alltable ata);
	
	public String isSelectAllpower(Alltable ata);
	
	public String isSelectAlloperate(Alltable ata);
	
	public String isSelectUser_name(Alltable ata);
	
	public String isSelectInGroup(String id);
	
	public int isSelectAdmin(Alltable ata);
	
	public List<Alltable> isSelectOperateInPower(Alltable ata);
	
	public List<Alltable> isSelectAdministrator(Alltable ata);
	
	public int isSelectAdminTotalCount(Alltable ata);
	
	public void isDeleteAdministrator(Alltable ata);
	
	public List<Alltable> isSelectPutongUser(Alltable ata);
	
	public List<Alltable> selectAllUser(Alltable ata);
	
	public int isSelectAdminTotalCount2(Alltable ata);
	
	public int isSelectAdminTotalCount3(Alltable ata);
	
	public List<Alltable> isSelectPowerAndOperate();
	
	public List<Alltable> isSelectGroupID();
	
	public List<Alltable> isSelectPowerID();
	
	public List<Alltable> isSelectOperateID();
	
	public long selectGuanliyuanguanliID();
	
	public List<Alltable> selectJigouguanliPowerID(long id);
	
	public List<Alltable> selectJigouguanliOperateID(long id);
	
	public void isInsertAllAdmin(Alltable ata);
	
	public void isInsertJigouAdmin(Alltable ata);
	
	public String isSelectAdminPower(Alltable ata);
	
	public String isSelectAdminOperate(Alltable ata);
	
	public void isUpdatePower(Alltable ata);
	
	public int isSelectXuanAdmin(Alltable ata);

}
