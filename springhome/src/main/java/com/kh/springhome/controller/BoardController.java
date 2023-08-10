package com.kh.springhome.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardDto>list =boardDao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/board/list.jsp";
	}
	@GetMapping("/write")
	public String write(HttpSession session) {
		String memberId=(String) session.getAttribute("name");
		if(memberId !=null) {
			return"/WEB-INF/views/board/write.jsp";
		}
		else {
			return"/WEB-INF/views/member/login.jsp";
		}
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto,HttpSession session) {
		//일단 시퀀스로 게시글 번호 가져오고 게시글 번호로 dto를 불러올수 있는가
		//게시글 번호랑 게시글 작성자가 필요한데
		//번호는 가져왔고
		//작성자를 어떻게 하지
		int boardNo =boardDao.sequence();
		String boardWriter=(String) session.getAttribute("name");
		boardDto.setBoardNo(boardNo);
		boardDto.setBoardWriter(boardWriter);
		boardDao.insert(boardDto);
		return"redirect:detail?boardNo="+boardNo;
	}
	
	
	
	
	
	
}








