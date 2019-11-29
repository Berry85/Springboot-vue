package com.example.demo.controller;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.House;
import com.example.demo.entity.RespBean;
import com.example.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
	@Autowired
	HouseService houseService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<House> house() {
		return houseService.getAllHouse();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public RespBean HouseInsert(House house) {
		Integer lid = UserUtils.getCurrentUser().getId();
		if (houseService.addHouse(house, lid) > 0) {
			return RespBean.ok("添加成功!");
		}
		return RespBean.error("添加失败!");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public RespBean HouseUpdate(House house) {
		if (houseService.EditHouse(house) == 1) {
			return RespBean.ok("更新成功!");
		}
		return RespBean.error("更新失败!");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public RespBean HouseDelete(Integer hid) {
		if (houseService.DeleteHouse(hid) == 1) {
			return RespBean.ok("删除成功!");
		}
		return RespBean.error("删除失败!");
	}

	@RequestMapping(value = "/ownerlist", method = RequestMethod.GET)
	public List<House> ownerlist() {
		return houseService.getUserHouse();
	}
}
