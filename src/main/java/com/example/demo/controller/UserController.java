package com.example.demo.controller;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public User getInfo() {
		return userService.getUserById(UserUtils.getCurrentUser().getId());
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public RespBean updateInfo(User user) {
		if (userService.updateUser(user) == 1) {
			return RespBean.error("更新成功");
		} else {
			return RespBean.ok("更新失败");
		}
	}
}
