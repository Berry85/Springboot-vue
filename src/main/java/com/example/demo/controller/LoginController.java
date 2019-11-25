package com.example.demo.controller;

import com.example.demo.entity.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping("/login_page")
	public RespBean login() {
		return RespBean.error("尚未登录，请登录");
	}

}
