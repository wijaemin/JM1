package com.wjm.springpractice.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
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
import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.error.NoTargetException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		int no = boardDao.sequence();
		boardDto.setNo(no);
		
		String email=(String) session.getAttribute("email");
		boardDto.setWriter(email);
		
		//이 사용자의 마지막 글번호 조회
		Integer lastNo=boardDao.selectMaxNo(email);
		
		boardDao.insert(boardDto);//글 등록
		
		//포인트 계산 작업
		//-lastNo가 null이면 신규 작성이라는 것
		//-lastNo가 null이 아니면 조회한 다음 시간차 비교
		if(lastNo == null) {//첫 글이라면
			memberDao.updatePoint(email,10);
		}
		else {//처음이 아니라면
			BoardDto lastDto=boardDao.selectOne(lastNo);
			Timestamp stamp = new Timestamp(lastDto.getCreatedAt().getTime());//TimeStamp로 마지막 작성글의 작성일 시간 담기
			LocalDateTime lastTime=stamp.toLocalDateTime();//LocalDateTime으로 변환
			LocalDateTime currentTime=LocalDateTime.now();//현재시간 LocalDateTime으로 변환
			
			Duration duration =Duration.between(lastTime, currentTime); //시간차 값 구하기
			long seconds=duration.getSeconds();//기간차 값 초로 변환
			if(seconds>300) {//시간차가 300초보다 크다면(5분 초과)
				memberDao.updatePoint(email,10);
			}
			
			
		}
		
		
		
		
		return "redirect:detail?no=" + no;
	}
	
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = type !=null && keyword != null;
		
		if(isSearch) {
			List<BoardDto>selectList= boardDao.selectList(type, keyword);
			model.addAttribute("list", selectList);
			model.addAttribute("isSearch",true);
		}
		else {
			List<BoardDto>selectList =boardDao.selectList();
			model.addAttribute("list", selectList);
			model.addAttribute("isSearch",false);
		}
		
		
		return "/WEB-INF/views/board/list.jsp";
		
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int no, Model model) {
		boardDao.updateReadcount(no);
		
		BoardDto boardDto = boardDao.selectOne(no);
	
		model.addAttribute("boardDto", boardDto);
		
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int no, Model model) {
		BoardDto boardDto = boardDao.selectOne(no);
		model.addAttribute("boardDto", boardDto);
		
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boolean result=boardDao.edit(boardDto);
		if(result) {
			return "redirect:detail?no="+ boardDto.getNo();
		}
		else {
			throw new NoTargetException("존재하지 않는 글번호");
		}
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result=boardDao.delete(no);
		if(result) {
			return "redirect:list";
		}
		else {
			throw new NoTargetException("존재하지 않는 글번호");
		}
	}
	
	
}
