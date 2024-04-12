package com.wjm.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
	//AutoWired는 지정한 클래스 및 자식 클래스에서
	//등록된 것을 찾아 주입한다.
	//등록한건 memberDaoImpl지만 memberDao를 써도 된다.
	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish(){
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
}
