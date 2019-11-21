package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	User loadUserByUsername(String username);

	List<Role> getUserRolesByUid(Integer id);

	//	新建账户
	int insertUser(@Param("username") String username, @Param("password") String password);

	//	修改密码
	int updateUserPassword(@Param("password") String password);

	//更新用户信息
	int updateUser(User user);

	//	根据关键字查找用户
	List<User> getUserByKeywords(@Param("keywords") String keywords);

	//	删除用户角色
	int deleteRoleByUserId(Integer id);

	//	为用户添加角色
	int addRolesForUser(@Param("UserId") Integer userId, @Param("rids") Integer[] rids);

	//	根据用户id获取用户信息
	User getUserById(Integer id);

	//	获取所有用户信息
	List<User> getAllUser(@Param("currentId") Integer currentId);
}

