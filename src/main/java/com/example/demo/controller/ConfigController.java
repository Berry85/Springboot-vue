package com.example.demo.controller;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.Menu;
import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//此处为不需要登录就可以访问的内容
@RestController
@RequestMapping("/config")
public class ConfigController {
	@Autowired
	MenuService menuService;
	@Autowired
	UserService userService;


	@RequestMapping(value = "/sysmenu", method = RequestMethod.GET)
	public List<Menu> SysMenu() {
		return menuService.getMenusByUserId();
	}


	@RequestMapping("/user")
	public User currentUser() {
		return UserUtils.getCurrentUser();
	}

	//租客注册
	@RequestMapping(value = "/TenantReg", method = RequestMethod.POST)
	public RespBean TenantReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.addRolesForUser(id, 3);
			return RespBean.ok("租客注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败！");
		}
		return RespBean.error("注册失败！");
	}

	//房东注册
	@RequestMapping(value = "/LandlordReg", method = RequestMethod.POST)
	public RespBean LandlordReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.addRolesForUser(id, 4);
			return RespBean.ok("房东注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败");
		}
		return RespBean.error("注册失败！");
	}
}
