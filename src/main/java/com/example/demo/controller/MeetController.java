package com.example.demo.controller;

import com.example.demo.common.UserUtils;
import com.example.demo.entity.Meet;
import com.example.demo.entity.RespBean;
import com.example.demo.service.HouseService;
import com.example.demo.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meet")
public class MeetController {

	@Autowired
	MeetService meetService;
	@Autowired
	HouseService houseService;

	//	申请会面
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public RespBean ApplyMeet(Integer hid) {
		int lid = houseService.FindLandlord(hid).getLid();
		int tid = UserUtils.getCurrentUser().getId();
		int i = meetService.Applymeet(lid, tid);
		if (i == 1) {
			return RespBean.ok("正在申请，请等候12小时");
		} else {
			return RespBean.error("申请失败");
		}
	}

	//	查看通过申请
	@RequestMapping(value = "/applysource", method = RequestMethod.GET)
	public List<Meet> applysource() {
		Integer tid = UserUtils.getCurrentUser().getId();
		return meetService.getApplySource(tid);
	}


	//	学生申请查看正在审核的数据
	@RequestMapping(value = "/applying", method = RequestMethod.GET)
	public List<Meet> getApplying() {
		Integer tid = UserUtils.getCurrentUser().getId();
		return meetService.getApplying(tid);
	}

	//	学生申请查看未通过的数据-->
	@RequestMapping(value = "/applied", method = RequestMethod.GET)
	public List<Meet> getApplied() {
		Integer tid = UserUtils.getCurrentUser().getId();
		return meetService.getApplied(tid);
	}


	//	查看会面信息（房东）
	@RequestMapping(value = "/Landlord_apply", method = RequestMethod.GET)
	public List<Meet> getApplyLandlord() {
		Integer lid = UserUtils.getCurrentUser().getId();
		return meetService.getApplyLandlord(lid);
	}

	//	管理员查看未审批的申请
	@RequestMapping(value = "/ApplyEnable", method = RequestMethod.GET)
	public List<Meet> getApplyEnable() {
		return meetService.getApplyEnable();
	}

	//	管理员查看所有申请
	@RequestMapping(value = "/AllApply", method = RequestMethod.GET)
	public List<Meet> getAllApply() {
		return meetService.getAllApply();
	}

}
