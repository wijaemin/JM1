package com.wjm.springpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.BoardListDto;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.error.NoTargetException;
import com.wjm.springpractice.vo.PaginationVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BoardDao boardDao;
	
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
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
	@RequestMapping("/member/detail")
	public String memberDetail(@RequestParam String email, Model model) {
		MemberDto memberDto = memberDao.selectOne(email);
		model.addAttribute("memberDto", memberDto);
		
		List<BoardListDto> boardList =boardDao.selectListByWriter(email);
		
		//이 회원이 작성한 글들을 조회해서 모델에 첨부(최근 5개만 출력하게 만듦)
		model.addAttribute("boardList", boardList);
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	
	@GetMapping("/member/edit")
	public String memberEdit(Model model, @RequestParam String email) {
		
		MemberDto memberDto = memberDao.selectOne(email);
		model.addAttribute("memberDto", memberDto);
		
		return "/WEB-INF/views/admin/member/edit.jsp";
	}
	@PostMapping("/member/edit")
	public String memberEdit(@ModelAttribute MemberDto memberDto) {
		
		boolean result= memberDao.updateMemberInfoByAdmin(memberDto);
//		if(result) return "redirect:list";//상대경로
		if(result) return "redirect:/admin/member/list";//절대경로
		else throw new NoTargetException("존재하지 않는 회원");
	}

}
