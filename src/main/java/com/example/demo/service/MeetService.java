package com.example.demo.service;

import com.example.demo.entity.Meet;
import com.example.demo.mapper.MeetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetService {
	@Autowired
	MeetMapper meetMapper;

	//	学生申请会面时间地点,地点为房屋地址，时间管理员定下来，
	public int Applymeet(Integer lid, Integer tid) {
		return meetMapper.Applymeet(lid, tid);
	}

	//	管理员批准，
	public int Apply(Integer id, String address, Date time) {
		return meetMapper.Apply(id, address, time);
	}

	//	学生查看申请结果
	public List<Meet> getApplySource(Integer tid) {
		return meetMapper.getApplySource(tid);
	}

	//	学生申请查看正在审核的数据
	public List<Meet> getApplying(Integer tid) {
		return meetMapper.getApplying(tid);
	}

	//	学生申请查看未通过的数据-->
	public List<Meet> getApplied(Integer tid) {
		return meetMapper.getApplied(tid);
	}

	//房主查看已经申请通过后的会面时间地点
	public List<Meet> getApplyLandlord(Integer lid) {
		return meetMapper.getApplyLandlord(lid);
	}

	//	管理员查看未审批的申请
	public List<Meet> getApplyEnable() {
		return meetMapper.getApplyEnable();
	}

	//	管理员查看所有申请
	public List<Meet> getAllApply() {
		return meetMapper.getAllApply();
	}

}
