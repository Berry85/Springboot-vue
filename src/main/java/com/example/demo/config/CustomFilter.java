package com.example.demo.config;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Role;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
	AntPathMatcher antPathMatcher = new AntPathMatcher();
	@Autowired
	MenuService menuService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object o)
			throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) o).getRequestUrl();
		List<Menu> menus = menuService.getAllMenus();
		for (Menu menu : menus) {
			if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
				List<Role> roles = menu.getRoles();
				String[] roleArr = new String[roles.size()];
				for (int i = 0; i < roleArr.length; i++) {
					roleArr[i] = roles.get(i).getName();
				}
				return SecurityConfig.createList(roleArr);
			}
		}
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return FilterInvocation.class.isAssignableFrom(aClass);
	}
}
