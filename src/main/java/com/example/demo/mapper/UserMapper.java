package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
	User loadUserByUsername(String username);
	List<Role> getUserRolesByUid(Integer id);
}
