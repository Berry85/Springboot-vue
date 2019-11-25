package com.example.demo.service;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.Menu;
import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
	@Autowired
	MenuMapper menuMapper;

	@Cacheable(key = "#root.methodName")
	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}

	public List<Menu> getMenusByUserId() {
		return menuMapper.getMenuByUserId(UserUtils.getCurrentUser().getId());
	}
}
