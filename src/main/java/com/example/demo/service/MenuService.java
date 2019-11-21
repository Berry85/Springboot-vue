package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
	@Autowired
	MenuMapper menuMapper;

	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}
}
