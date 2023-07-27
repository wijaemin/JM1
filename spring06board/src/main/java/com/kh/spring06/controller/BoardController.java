package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dto.BoardDto;

@RestController
public class BoardController {
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto) {
		dao.insert(dto);
		return "등록 완료!";
		
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute BoardDto dto) {
		boolean result=dao.update(dto);
		if(result) return "게시판 정보 변경 완료";
		else return "없는 게시판 번호 입니다";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boolean result=dao.delete(boardNo);
		if(result) return "게시판 정보 삭제 완료";
		else return "게시판에 없는 번호입니다";
	}
}
