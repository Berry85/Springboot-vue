package com.example.demo.mapper;

import com.example.demo.entity.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseMapper {

	//查询所有房屋
	List<House> getAllHouse();

	//	查询自己拥有的房屋
	List<House> getUserHouse(Integer lid);

	//	新增房屋
	int addHouse(@Param("house") House house, @Param("lid") Integer lid);

	//	修改房屋
	int EditHouse(House house);

	//	删除房屋
	int DeleteHouse(Integer hid);

	//	根据房屋id找到房主id
	House FindLandlord(Integer hid);
}
