package com.wjm.springpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.vo.PaginationVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/admin/home.jsp";
	}
	
	@RequestMapping("/member/list")
	public String memberList(@ModelAttribute PaginationVO vo, Model model) {
		int count = memberDao.countList(vo);//vo를 넣는 이유는 검색일 때 dao의 조회 구문이 달라지기 때문
		vo.setCount(count);
		model.addAttribute("vo",vo);
		
		List<MemberDto> list = memberDao.selectListByPage(vo);
		
		log.debug("list={}",list);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/admin/member/list.jsp";
	}
}
