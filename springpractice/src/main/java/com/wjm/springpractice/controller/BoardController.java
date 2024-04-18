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
import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.error.NoTargetException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
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
		
		boardDao.insert(boardDto);
		
		return "redirect:detail?no=" + no;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<BoardDto>selectList =boardDao.selectList();
		
		model.addAttribute("list", selectList);
		
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
