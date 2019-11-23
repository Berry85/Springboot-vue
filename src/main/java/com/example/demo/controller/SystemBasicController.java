package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.entity.RespBean;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//此处为不需要登录就可以访问的内容
@RestController
@RequestMapping("/system/basic")
public class SystemBasicController {
	@Autowired
	MenuService menuService;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@RequestMapping("/menu_list")
	public List<Menu> SysAllMenu() {
		return menuService.getAllMenus();
	}


	@RequestMapping(value = "/TenantReg", method = RequestMethod.POST)
	public RespBean TenantReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.updateRolesForUser(id, 3);
			return RespBean.ok("房客注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败！");
		}
		return RespBean.error("注册失败！");
	}

	@RequestMapping(value = "/LandlordReg", method = RequestMethod.POST)
	public RespBean LandlordReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.updateRolesForUser(id, 4);
			return RespBean.ok("房东注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败");
		}
		return RespBean.error("注册失败！");
	}
}
