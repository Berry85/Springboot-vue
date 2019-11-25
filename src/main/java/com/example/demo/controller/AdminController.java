package com.example.demo.controller;

import com.example.demo.entity.User;
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

	@RequestMapping(value = "/landlord_list", method = RequestMethod.GET)
	public List<User> landlord_list() {
		return userService.getAllLandlord();
	}

	@RequestMapping(value = "/tenant_list", method = RequestMethod.GET)
	public List<User> tenant_list() {
		return userService.getAllTenant();
	}


	@RequestMapping(value = "/landlord_list/locked", method = RequestMethod.POST)
	public String LandlordLock(String locked) {
		return "已锁定";
	}

	@RequestMapping(value = "/tenant_list/locked", method = RequestMethod.POST)
	public String TenantLock(String locked) {
		return "已锁定";
	}


	//	@RequestMapping(value = "/house_list", method = RequestMethod.GET)
//	public List<User> house_list() {
//		return userService.getAllLandlord();
//	}
}
