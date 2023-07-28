package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring08.dao.MemberDao;
import com.kh.spring08.dto.MemberDto;

@RestController
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/join")
	public String join(@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "등록 완료";
	}
	@RequestMapping("/password")
	public String password(@ModelAttribute MemberDto dto) {
		boolean result =dao.updatePw(dto);
		if(result) return "비밀번호 변경 완료";
		else return "존재하지 않는 아이디입니다";
	}
	@RequestMapping("/change")
	public String change(@ModelAttribute MemberDto dto) {
		boolean result=dao.update(dto);
		if(result) return "개인정보 변경 완료";
		else return "존재하지 않는 아이디입니다";
	}
	@RequestMapping("/exit")
	public String exit(@RequestParam String memberId) {
		boolean result=dao.delete(memberId);
		if(result) return "회원 삭제 완료";
		else return "존재하지 않는 아이디입니다";
	}
	@RequestMapping("/list")
	public String list() {
		List<MemberDto>list=dao.selectList();
		StringBuffer buffer=new StringBuffer();
		for(MemberDto dto:list) {
			buffer.append(dto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId) {
		MemberDto dto=dao.selectOne(memberId);
		if(dto==null) return "없는 아이디 입니다";
		else {
			return dto.toString();
		}
		
	}	
}
