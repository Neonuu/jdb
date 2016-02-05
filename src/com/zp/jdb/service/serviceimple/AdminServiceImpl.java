package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.AlltableDao;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.service.AdminService;


@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	@Resource
	private AlltableDao dao;
	
	public List<Alltable> isSelectGroupAndPower() {
		return dao.selectGroupAndPower();
	}
	public List<Alltable> isSelectGroup() {
		return dao.selectGroup();
	}
	public int isSelectID(Alltable ata) {
		return dao.selectID(ata);
	}
	public String isSelectAllpower(Alltable ata) {
		return dao.selectAllpower(ata);
	}
	public String isSelectAlloperate(Alltable ata) {
		return dao.selectAlloperate(ata);
	}
	public String isSelectUser_name(Alltable ata) {
		return dao.selectUser_name(ata);
	}
	public String isSelectInGroup(String id) {
		return dao.selectInGroup(id);
	}
	public int isSelectAdmin(Alltable ata) {
		return dao.selectAdmin(ata);
	}
	public List<Alltable> isSelectOperateInPower(Alltable ata) {
		return dao.selectOperateInPower(ata);
	}
	public List<Alltable> isSelectAdministrator(Alltable ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.selectAdministrator(ata);
	}
	public int isSelectAdminTotalCount(Alltable ata) {
		return dao.selectAdminTotalCount(ata);
	}
	public void isDeleteAdministrator(Alltable ata) {
		dao.deleteAdministrator(ata);
		return;
	}
	public List<Alltable> isSelectPutongUser(Alltable ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.selectPutongUser(ata);
	}
	public int isSelectAdminTotalCount2(Alltable ata) {
		return dao.selectAdminTotalCount2(ata);
	}
	public List<Alltable> isSelectPowerAndOperate() {
		return dao.selectPowerAndOperate();
	}
	public List<Alltable> isSelectGroupID() {
		return dao.selectGroupID();
	}
	public List<Alltable> isSelectOperateID() {
		return dao.selectOperateID();
	}
	public List<Alltable> isSelectPowerID() {
		return dao.selectPowerID();
	}
	public long selectGuanliyuanguanliID() {
		return dao.selectGuanliyuanguanliID();
	}
	public List<Alltable> selectJigouguanliPowerID(long id) {
		return dao.selectJigouguanliPowerID(id);
	}
	public List<Alltable> selectJigouguanliOperateID(long id) {
		return dao.selectJigouguanliOperateID(id);
	}
	public void isInsertAllAdmin(Alltable ata) {
		dao.insertAllAdmin(ata);
		return;
	}
	public void isInsertJigouAdmin(Alltable ata) {
		dao.insertJigouAdmin(ata);
		return;
	}
	public String isSelectAdminPower(Alltable ata) {
		return dao.selectAdminPower(ata);
	}
	public String isSelectAdminOperate(Alltable ata) {
		return dao.selectAdminOperate(ata);
	}
	public void isUpdatePower(Alltable ata) {
		dao.updatePower(ata);
		return;
	}
	public int isSelectXuanAdmin(Alltable ata) {
		return dao.selectXuanAdmin(ata);
	}
	public List<Alltable> selectAllUser(Alltable ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.selectAllUser(ata);
	}
	public int isSelectAdminTotalCount3(Alltable ata) {
		return dao.selectAdminTotalCount3(ata);
	}
}
