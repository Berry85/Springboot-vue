package com.example.demo.service;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.House;
import com.example.demo.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
	@Autowired
	HouseMapper houseMapper;

	//查询所有房屋
	public List<House> getAllHouse() {
		return houseMapper.getAllHouse();
	}

	//	查询自己拥有的房屋
	public List<House> getUserHouse() {
		return houseMapper.getUserHouse(UserUtils.getCurrentUser().getId());
	}

	//	新增房屋
	public int addHouse(House house, Integer lid) {
		return houseMapper.addHouse(house, lid);
	}

	//	修改房屋
	public int EditHouse(House house) {
		return houseMapper.EditHouse(house);
	}

	//	删除房屋
	public int DeleteHouse(Integer hid) {
		return houseMapper.DeleteHouse(hid);
	}
}
