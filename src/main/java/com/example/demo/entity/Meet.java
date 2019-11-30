package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meet {
	private Integer id;
	private Integer tid;
	private Integer lid;
	private String address;
	private Date time;
	private Integer enable;
	private User landlord;
	private User tenant;
	private MeetName name;

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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(time);
	}

	public void setTime(String time) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			this.time = f.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@JsonIgnore
	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public User getLandlord() {
		return landlord;
	}

	public void setLandlord(User landlord) {
		this.landlord = landlord;
	}

	public User getTenant() {
		return tenant;
	}

	public void setTenant(User tenant) {
		this.tenant = tenant;
	}

	public MeetName getName() {
		return name;
	}

	public void setName(MeetName name) {
		this.name = name;
	}
}
