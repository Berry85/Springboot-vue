package com.example.demo.controller;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.Menu;
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


}
