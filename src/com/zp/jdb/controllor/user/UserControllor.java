package com.zp.jdb.controllor.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.user.User;
import com.zp.jdb.service.user.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserControllor {
	@Resource
	private UserService userService;

	@RequestMapping(value = "/showList.do")
	public String showList() {
		return "";
	}

	// ������ѯ��ģ���ѯ

	// /////////////////////test//////////////////////////
	/**
	 * ����crud����
	 */
	@RequestMapping(value = "/test.do")
	public void test() {
		User user = new User();
		user.setPhoneNumber("123456");

		// ok1
		// userService.addUser(user);
		// ok2
		// userService.delUser(user);
		// ok3
		// userService.updataUser(user);
		// ok4
		// List<User> list = userService.findUser(user);
		// System.out.println(list);
		// System.out.println("===");
		// if (list != null) {
		// for (User u : list) {
		// System.out.println(u.toString());
		// }
		// }
		// ok5
		User u = userService.findUserById(1);
		// ok6
		// List<Customer> list = userService.findUser_customer(user);
		// System.out.println(list);
		// if (list != null) {
		// for (Customer c : list) {
		// System.out.println(c.toString());
		// }
		// }
		// ok7
		// List<UserJiaoDanLiangNum> queryJiaoDanLiang =
		// userService.queryJiaoDanLiang();
		//
		// for(UserJiaoDanLiangNum u:queryJiaoDanLiang){
		// System.out.println(u);
		// }
	}
}
