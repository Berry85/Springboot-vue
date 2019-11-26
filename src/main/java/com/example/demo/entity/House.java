package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class House {
	private Integer id;
	private String address;
	private String status;
	private Double area;
	private Double price;
	private Timestamp UploadDate;
	private Integer lid;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getUploadDate() {
		return UploadDate;
	}

	@JsonIgnore
	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}
}
