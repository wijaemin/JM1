package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.BookDao;
import com.kh.spring07.dto.BookDto;

@RestController
public class BookController {
	@Autowired
	private BookDao dao;
	
	
	@RequestMapping("/save")
	public String save(@ModelAttribute BookDto dto) {
		dao.insert(dto);
		return "등록완료요";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute BookDto dto) {
		boolean result =dao.update(dto);
		if(result) {
			return "수정 완료";
		}
		else return "없는 아이디 입니다";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		boolean result =dao.delete(bookId);
		if(result) return "삭제 완료";
		else return "존재하지 않는 아이디입니다";
	}	
	@RequestMapping("/list")
		public String list() {
		List<BookDto>list=dao.selectList();
		StringBuffer buffer=new StringBuffer();
		for(BookDto dto:list) {
			buffer.append(dto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) {
		BookDto dto=dao.selectOne(bookId);
		if(dto==null) return "없는 아이디 입니다";
		else {
			
			return dto.toString();
		}
	}
	
	
	
}
