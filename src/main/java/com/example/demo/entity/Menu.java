package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Menu {
	private Integer id;
	private String url;
	private String path;
	private Object component;
	private Integer parent_id;
	private String name;
	private String iconCls;
	private Boolean enable;
	private List<Role> roles;
	private List<MenuMeta> children;
	private MenuMeta meta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public Object getComponent() {
		return component;
	}

	public void setComponent(Object component) {
		this.component = component;
	}

	@JsonIgnore
	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public MenuMeta getMeta() {
		return meta;
	}

	public void setMeta(MenuMeta meta) {
		this.meta = meta;
	}

	public List<MenuMeta> getChildren() {
		return children;
	}

	public void setChildren(List<MenuMeta> children) {
		this.children = children;
	}
}
