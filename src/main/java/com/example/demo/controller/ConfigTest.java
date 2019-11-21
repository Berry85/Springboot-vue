package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.entity.RespBean;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//此处为不需要登录就可以访问的内容
@RestController
@RequestMapping("/sys")
public class ConfigTest {
	@Autowired
	MenuService menuService;
	@Autowired
	UserService userService;

	@RequestMapping("/menu_list")
	public List<Menu> sysmenu() {
		return menuService.getAllMenus();
	}


	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public RespBean TenantReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			return RespBean.ok("注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败");
		}
		return RespBean.error("注册失败！");
	}
}
