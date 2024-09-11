package com.wjm.springpractice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.dto.StatDto;

@CrossOrigin
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	@PostMapping("/emailCheck")
	public String emailCheck(@RequestParam String email) {
		MemberDto memberDto =memberDao.selectOne(email);
		if(memberDto==null) {
			return "Y";
		}
		else {
			return "N";
		}
	}
	
	@PostMapping("/nicknameCheck")
	public String nicknameCheck(@RequestParam String nickname) {
		MemberDto memberDto = memberDao.selectOneByNickname(nickname);
		if(memberDto == null) {
			return "Y";
		}
		else {
			return "N";
		}
	}
	
	
	@GetMapping("/stat/count")
	public List<StatDto> statCount(){
		return memberDao.selectGroupByRank();
		
	}
	
}
