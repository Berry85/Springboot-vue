package com.example.demo.mapper;

import com.example.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
	List<Menu> getAllMenus();

	//	根据用户id获取角色
	int getRolesByUserId(Integer id);
}
