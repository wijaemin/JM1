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
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dto.BoardDto;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	public String list(Model model,@RequestParam (required = false)String keyword, 
			@RequestParam  (required = false)String type) {
		boolean isFind = (keyword !=null && type != null);
		
		if(isFind) {
			List<BoardDto>searchList=boardDao.searchList(type, keyword);
			model.addAttribute("searchList", searchList);
			return "/WEB-INF/views/board/list.jsp";
			
		}
		else {
			List<BoardDto>list =boardDao.selectList();
			model.addAttribute("list", list);
			return "/WEB-INF/views/board/list.jsp";
			
		}
		
		
		
		
		
		
		
		
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
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo,Model model) {
		BoardDto boardDto=boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		boardDao.readecountPlus(boardNo);
		return "/WEB-INF/views/board/detail.jsp";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo,HttpSession session) {
		//지울 때 조건
		//일단 게시글 아이디와 현재 아이디가 같아야한다 그렇다는건
//		String memberId=(String) session.getAttribute("name");//현재 아이디 가져오고
//		BoardDto boardDto=boardDao.selectOne(boardNo);//게시글 번호의 디토 가져오고
		
		boardDao.delete(boardNo);
		return "redirect:list";
//		if(memberId.equals(boardDto.getBoardWriter())){//현재 아이디와 게시글 아이디가 같으면?
//			boardDao.delete(boardNo);//지워버리기
//			return "redirect:list";
//		}
//		else {
//			return "redirect:detail?boardNo="+boardNo+"?error";
//		}
		
	}
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo,Model model) {
		BoardDto boardDto=boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto inputDto) {///edit.jsp에서 입력한 값 가져오기
		
		
		boardDao.update(inputDto);
		return "redirect:detail?boardNo="+inputDto.getBoardNo();
		
	}

	
	
}








