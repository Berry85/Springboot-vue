package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigTest {
	@Autowired
	MenuService menuService;

	@RequestMapping("/sys/menu_list")
	public List<Menu> sysmenu() {
		return menuService.getAllMenus();
	}
}
