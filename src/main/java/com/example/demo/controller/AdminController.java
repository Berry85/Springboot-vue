package com.example.demo.controller;

import com.example.demo.entity.House;
import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.HouseService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys")
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	HouseService houseService;

	@RequestMapping(value = "/landlord_list", method = RequestMethod.GET)
	public List<User> landlord_list() {
		return userService.getAllLandlord();
	}

	@RequestMapping(value = "/tenant_list", method = RequestMethod.GET)
	public List<User> tenant_list() {
		return userService.getAllTenant();
	}


	@RequestMapping(value = "/tenantlocked", method = RequestMethod.POST)
	public RespBean TenantLock(Integer uid) {
		int i = userService.lockedUser(uid);
		if (i == 1) {
			return RespBean.ok("已锁");
		} else {
			return RespBean.error("上锁失败");
		}
	}

	@RequestMapping(value = "/landlordlocked", method = RequestMethod.POST)
	public RespBean LandlordLock(Integer uid) {
		int i = userService.lockedUser(uid);
		if (i == 1) {
			return RespBean.ok("已锁");
		} else {
			return RespBean.error("上锁失败");
		}
	}

	//获取所有房屋列表
	@RequestMapping(value = "/house_list", method = RequestMethod.GET)
	public List<House> house_list() {
		return houseService.getAllHouse();
	}

	@RequestMapping(value = "/house/edit/{id}", method = RequestMethod.POST)
	public RespBean HouseEdit(House house) {
		int i = houseService.EditHouse(house);
		if (i == 1) {
			return RespBean.ok("修改成功");
		}
		return RespBean.error("修改失败");
	}

	@RequestMapping(value = "/house/delete/{id}", method = RequestMethod.DELETE)
	public RespBean HouseDelete(Integer hid) {
		int i = houseService.DeleteHouse(hid);
		if (i == 1) {
			return RespBean.ok("删除成功");
		}
		return RespBean.error("删除失败");
	}
}
