package com.example.demo.mapper;

import com.example.demo.entity.Meet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MeetMapper {
	//	学生申请会面时间地点
	int Applymeet(@Param("meet") Meet meet, @Param("hid") Integer hid, @Param("tid") Integer tid);

	//	管理员批准，
	int Apply();

	//	学生查看申请结果
	List<Meet> getApplySource(Integer tid);

	//	学生申请查看正在审核的数据
	List<Meet> getApplying(Integer tid);

	//房主查看已经申请通过后的会面时间地点
	List<Meet> getApplyLandlord(Integer lid);

	//	管理员查看所有申请
	List<Meet> getAllApply(String enabled_zh);

}
