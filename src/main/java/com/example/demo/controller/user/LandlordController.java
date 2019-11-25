package com.example.demo.controller.user;

import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/landlord")
public class LandlordController {
	@Autowired
	UserService userService;

	//查看个人信息
	//查看个人信息
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public User getInfo(Integer id) {
		return userService.getUserById(id);
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

	//见面查看
	@RequestMapping(value = "/meet", method = RequestMethod.GET)
	public RespBean meet() {
		return RespBean.ok("a");
	}

	//租屋信息查看
	@RequestMapping(value = "/house", method = RequestMethod.GET)
	public RespBean house() {
		return RespBean.ok("a");
	}

	//	租屋新增
	@RequestMapping(value = "/house/insert", method = RequestMethod.POST)
	public RespBean HouseInsert() {
		return RespBean.ok("a");
	}

	//	租屋修改
	@RequestMapping(value = "/house/update/{id}", method = RequestMethod.POST)
	public RespBean HouseUpdate() {
		return RespBean.ok("a");
	}

	//  删除房屋
	@RequestMapping(value = "/house/delete/{id}", method = RequestMethod.DELETE)
	public RespBean HouseDelete() {
		return RespBean.ok("a");
	}
}
