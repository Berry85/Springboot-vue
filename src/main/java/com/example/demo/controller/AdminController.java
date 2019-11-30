package com.example.demo.controller;

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

	@RequestMapping(value = "/landlord", method = RequestMethod.GET)
	public List<User> landlord() {
		return userService.getAllLandlord();
	}

	@RequestMapping(value = "/tenant", method = RequestMethod.GET)
	public List<User> tenant() {
		return userService.getAllTenant();
	}

}
