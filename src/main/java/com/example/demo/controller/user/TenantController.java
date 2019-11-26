package com.example.demo.controller.user;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//只有房客的访问
@RestController
@RequestMapping("/tenant")
public class TenantController {
	@Autowired
	UserService userService;

	//查看个人信息
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public User getInfo() {
		return userService.getUserById(UserUtils.getCurrentUser().getId());
	}

	//更新个人信息
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public RespBean updateInfo(User user) {
		if (userService.updateUser(user) == 1) {
			return RespBean.error("更新成功");
		} else {
			return RespBean.ok("更新失败");
		}
	}

	//见面申请
	@RequestMapping(value = "/meet", method = RequestMethod.POST)
	public RespBean meet() {
		return RespBean.ok("a");
	}

	//租屋合同
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public RespBean contract() {
		return RespBean.ok("a");
	}

}
