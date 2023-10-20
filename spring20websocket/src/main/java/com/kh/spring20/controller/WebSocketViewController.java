package com.kh.spring20.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring20.dto.MemberDto;

@Controller
public class WebSocketViewController {
	
	@RequestMapping("/")
	public String home() {
//		return"/WEB-INF/views/home.jsp";
		return "home";
	}
	
	@RequestMapping("/default")
	public String defaultServer() {
//		return "/WEB-INF/views/default.jsp";
		return "default";
	}
	
	@RequestMapping("/time")
	public String timeServer() {
		return "time";
	}
	
	@RequestMapping("/group")
	public String group() {
		return "group";
		
	}
	//임시 로그인 처리
	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		MemberDto findDto = sqlSession.selectOne("member.find",memberDto);
		if (findDto !=null) {
			boolean pwMatch = findDto.getMemberPw().equals(memberDto.getMemberPw());
			if(pwMatch) {
				session.setAttribute("name", findDto.getMemberId());//아이디
				session.setAttribute("level", findDto.getMemberLevel());//등급
			}
		}
		
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("level");
		return "redirect:/";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
}
