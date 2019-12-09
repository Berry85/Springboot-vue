package com.example.demo.controller;

import com.example.demo.entity.RespBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegController {
	@Autowired
	UserService userService;

	//租客注册
	@RequestMapping(value = "/TenantReg", method = RequestMethod.POST)
	public RespBean TenantReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.addRolesForUser(id, 3);
			return RespBean.ok("租客注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败！");
		}
		return RespBean.error("注册失败！");
	}

	//房东注册
	@RequestMapping(value = "/LandlordReg", method = RequestMethod.POST)
	public RespBean LandlordReg(String username, String password) {
		int i = userService.UserInsert(username, password);
		if (i == 1) {
			int id = userService.getUserId(username);
			userService.addRolesForUser(id, 4);
			return RespBean.ok("房东注册成功");
		} else if (i == -1) {
			return RespBean.error("用户名重复，注册失败");
		}
		return RespBean.error("注册失败！");
	}
}
