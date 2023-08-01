package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.dto.PocketmonDto;

@Controller
@RequestMapping("/pocketmon")
public class PocketmonController {
	
	@Autowired//필요한거 내놔
	private PocketmonDao dao;
	
	@RequestMapping("/detail")
	public String test3(Model model, 
	@RequestParam int no) {
	PocketmonDto dto=dao.selectOne(no);
		
	if(dto==null) {
		
		model.addAttribute("error","없는 포켓몬 번호입니다");
		
		return "/WEB-INF/views/test04.jsp";
	}
			
		else {
			model.addAttribute("no", dto.getNo());
			model.addAttribute("name", dto.getName());
			model.addAttribute("type", dto.getType());
			
			return "/WEB-INF/views/test03.jsp";
		}
		
	}
}
