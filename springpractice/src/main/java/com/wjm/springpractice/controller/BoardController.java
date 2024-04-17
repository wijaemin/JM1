package com.wjm.springpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<BoardDto>selectList =boardDao.selectList();
		
		model.addAttribute("list", selectList);
		
		return "/WEB-INF/views/board/list.jsp";
		
	}
	
	
}
