package com.kh.springhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.AdminDao;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;
import com.kh.springhome.vo.PaginationVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminDao adminDao;
	

	
	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/admin/home.jsp";
	}
	@RequestMapping("/member/list")
	public String list(@ModelAttribute(name = "vo") PaginationVO vo,
			Model model) {
		int count=adminDao.countList(vo);
		vo.setCount(count);
		vo.setSize(20);
		List<MemberListDto>list=adminDao.selectListByPage(vo);
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	@RequestMapping("/member/detail")
	public String detail(@RequestParam String memberId,Model model) {
		MemberDto memberDto = adminDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
}
