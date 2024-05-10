package com.wjm.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wjm.springpractice.dao.MemberDao;
import com.wjm.springpractice.dto.MemberBlockDto;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.error.AuthorityException;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @ModelAttribute MemberDto inputDto) {
		MemberDto findDto = memberDao.selectOne(inputDto.getEmail());
		if(findDto ==null) {
			return "redirect:login?error";
		}
		String email=findDto.getEmail();
		String rank=findDto.getRank();
		boolean isCorrectPw=findDto.getPassword().equals(inputDto.getPassword());
		
		if(isCorrectPw) {
			//(주의) 만약 차단된 회원이라면 추가 작업을 중지하고 오류 발생
			MemberBlockDto blockDto = memberDao.selectBlockOne(email);
			if(blockDto != null) {
				throw new AuthorityException("차단된 회원");
			}
			session.setAttribute("email", email);
			session.setAttribute("rank", rank);
			memberDao.updateLoginAt(email);
			return "redirect:/";
		}
		else {
			return "redirect:login?error";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		session.removeAttribute("rank");
		return "redirect:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		// 세션에서 이메일 값 가져오기
		//세션은 값을 Object로 저장한다 (아무거나 넣을 수 있어야해서)
		String email= (String) session.getAttribute("email");
		MemberDto memberDto =memberDao.selectOne(email);
		model.addAttribute("memberDto",memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	@GetMapping("/changePw")
	public String changePw() {
		return "/WEB-INF/views/member/changePw.jsp";
	}
	
	@PostMapping("/changePw")
	public String changePw(HttpSession session, 
							@RequestParam String originPw, 
							@RequestParam String changePw) {
		
		String email=(String) session.getAttribute("email");
		MemberDto memberDto =memberDao.selectOne(email);
		if(memberDto.getPassword().equals(originPw)) {
			memberDao.changePw(email, changePw);
			return "redirect:changePwFinish";
		}
		else {
			return "redirect:changePw?error";
		}
	}
	
	@RequestMapping("/changePwFinish")
	
	public String changePwFinish() {
		return "/WEB-INF/views/member/changePwFinish.jsp";
	}
	
	@GetMapping("/changeInfo")
	public String changeInfo(HttpSession session, Model model) {
		String email=(String) session.getAttribute("email");
		
		MemberDto memberDto =memberDao.selectOne(email);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/changeInfo.jsp";
	}
	
	@PostMapping("/changeInfo")
	public String changeInfo(HttpSession session,@ModelAttribute MemberDto inputDto) {
		String email=(String) session.getAttribute("email");
		MemberDto findDto =memberDao.selectOne(email);
		if(findDto.getPassword().equals(inputDto.getPassword())) {
			inputDto.setEmail(email);
			memberDao.changeInfo(inputDto);
			return "redirect:changeInfoFinish";
		}
		else {
			return "redirect:changeInfo?error";
		}
	}
	
	@RequestMapping("/changeInfoFinish")
	public String changeInfoFinish() {
		return "/WEB-INF/views/member/changeInfoFinish.jsp";
	}

	@GetMapping("/exit")
	public String exit() {
		return "/WEB-INF/views/member/exit.jsp";
	}
	
	@PostMapping("/exit")
	public String exit(HttpSession session, @RequestParam String password) {
		String email=(String) session.getAttribute("email");
		MemberDto memberDto=memberDao.selectOne(email);
		
		if(memberDto.getPassword().equals(password)) {
			memberDao.exit(email);
			session.removeAttribute("email");
			
			return "redirect:exitFinish";
		}
		else {
			return "redirect:exit?error";
		}
		
	}
	@RequestMapping("/exitFinish")
	public String exitFinish() {
		return "/WEB-INF/views/member/exitFinish.jsp";
	}
}







