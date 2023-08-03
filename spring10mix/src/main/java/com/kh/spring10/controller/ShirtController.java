package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.dao.ShirtDao;

@Controller
@RequestMapping("/shirt")
public class ShirtController {
	
	@Autowired
	private ShirtDao dao;
	
	
//	@GetMapping("/add")
//	public String add() {
//		return "/WEB-INF/views/shirt/add.jsp";
//	}
//	@PostMapping("/add")
//	public String add() {
//		
//	}
	
}
