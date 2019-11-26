package com.example.demo.entity;

import java.util.Calendar;
import java.util.Date;

public class Contract {
	private Integer id;
	private Integer tid;//tenant租客
	private Integer lid;//Landlord房东
	private Integer hid;//house
	private Date StartDate;//开始// 时间
	private Date EndDate;//到期日
	private Integer Time;//合同时间，单位月


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate() {
		Date date = new Date();
		this.StartDate = date;
	}

	public Integer getTime() {
		return Time;
	}

	public void setTime(Integer time) {
		Time = time;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Integer t) {
		Date start = getStartDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);//设置起时间
		cal.add(Calendar.MONTH, t);
		this.EndDate = cal.getTime();
	}
}
