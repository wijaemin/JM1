package com.wjm.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "/WEB-INF/views/home.jsp";
	}
	
}
