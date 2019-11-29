package com.example.demo.controller.user;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.House;
import com.example.demo.entity.Meet;
import com.example.demo.entity.RespBean;
import com.example.demo.entity.User;
import com.example.demo.service.HouseService;
import com.example.demo.service.MeetService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/landlord")
public class LandlordController {
	@Autowired
	UserService userService;
	@Autowired
	HouseService houseService;
	@Autowired
	MeetService meetService;

	//查看个人信息
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	public User getInfo() {
		return userService.getUserById(UserUtils.getCurrentUser().getId());
	}

	//更新个人信息
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public RespBean updateInfo(User user) {
		if (userService.updateUser(user) == 1) {
			return RespBean.error("更新成功");
		} else {
			return RespBean.ok("更新失败");
		}
	}

	//见面查看
	@RequestMapping(value = "/meet", method = RequestMethod.GET)
	public List<Meet> meet() {
		return meetService.getApplyLandlord(UserUtils.getCurrentUser().getId());
	}

	//租屋信息查看
	@RequestMapping(value = "/house", method = RequestMethod.GET)
	public List<House> house() {
		return houseService.getUserHouse();
	}

	//	租屋新增
	@RequestMapping(value = "/house/insert", method = RequestMethod.POST)
	public RespBean HouseInsert(House house) {
		Integer lid = UserUtils.getCurrentUser().getId();
		if (houseService.addHouse(house, lid) > 0) {
			return RespBean.ok("添加成功!");
		}
		return RespBean.error("添加失败!");
	}

	//	租屋修改
	@RequestMapping(value = "/house/update/{id}", method = RequestMethod.PUT)
	public RespBean HouseUpdate(House house) {
		if (houseService.EditHouse(house) == 1) {
			return RespBean.ok("更新成功!");
		}
		return RespBean.error("更新失败!");
	}

	//  删除房屋
	@RequestMapping(value = "/house/delete/{id}", method = RequestMethod.DELETE)
	public RespBean HouseDelete(Integer hid) {
		if (houseService.DeleteHouse(hid) == 1) {
			return RespBean.ok("删除成功!");
		}
		return RespBean.error("删除失败!");
	}
}
