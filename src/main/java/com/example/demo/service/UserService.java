package com.example.demo.service;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserMapper userMapper;

	//	登录
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userMapper.loadUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("账户不存在");
		}
		user.setRoles(userMapper.getUserRolesByUid(user.getId()));
		return user;
	}

	//	注册
	public int UserInsert(String username, String password) {
		//如果用户名存在，返回错误
		if (userMapper.loadUserByUsername(username) != null) {
			return -1;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode(password);
		return userMapper.insertUser(username, encode);
	}

	//根据账户名查找用户id
	public int getUserId(String username) {
		return userMapper.loadUserByUsername(username).getId();
	}

	//	更新账户内容

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	//	根据关键字查找用户
	public List<User> getUserByKeywords(String keywords) {
		return userMapper.getUserByKeywords(keywords);
	}

	//	为用户添加角色，要先删除原来角色表的角色
	public int updateRolesForUser(Integer userId, Integer rid) {
//		int i = userMapper.deleteRoleByUserId(userId);
		return userMapper.addRolesForUser(userId, rid);
	}

	//	根据用户id获取用户信息
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	public List<User> getAllHrExceptAdmin() {
		return userMapper.getAllUser(UserUtils.getCurrentUser().getId());
	}

	//	获取所有用户信息
	public List<User> getAllUser(Integer currentId) {
		return userMapper.getAllUser(null);
	}

}
