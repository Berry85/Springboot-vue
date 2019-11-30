package com.example.demo.mapper;

import com.example.demo.entity.Meet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MeetMapper {
	//	学生申请会面时间地点,地点为房屋地址，时间管理员定下来，
	int Applymeet(@Param("lid") Integer lid, @Param("tid") Integer tid);

	//	管理员批准，
	int Apply(@Param("id") Integer id, @Param("address") String address, @Param("time") Date time);

	//	学生查看申请结果
	List<Meet> getApplySource(Integer tid);

	//	学生申请查看正在审核的数据
	List<Meet> getApplying(Integer tid);

	//	学生申请查看未通过的数据-->
	List<Meet> getApplied(Integer tid);

	//房主查看已经申请通过后的会面时间地点
	List<Meet> getApplyLandlord(Integer lid);

	//	管理员查看未审批的申请
	List<Meet> getApplyEnable();

	//	管理员查看所有申请
	List<Meet> getAllApply();
}
