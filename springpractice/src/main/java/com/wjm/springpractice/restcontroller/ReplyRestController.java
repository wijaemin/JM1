package com.wjm.springpractice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjm.springpractice.dao.ReplyDao;
import com.wjm.springpractice.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	
	@Autowired
	private ReplyDao replyDao;
	
	//댓글 등록
	//사용자가 입력한 내용을 특정 번호의 게시글 아래로 등록하도록 구현
	
	//사용자는 댓글내용(content)만 작성
	//댓글번호(no)는 시퀀스로 생성
	//작성자(writer)는 세션에서 조회
	//작성일(created_at)은 db에서 sysdate로 등록
	//원본글번호(origin)은 사용자 몰래 전송
	@PostMapping("/insert")
	public void insert(@ModelAttribute ReplyDto replyDto, HttpSession session) {
		int replyNo=replyDao.sequence();
		replyDto.setNo(replyNo);
		
		String email=(String)session.getAttribute("email");
		replyDto.setWriter(email);
		
		replyDao.insert(replyDto);
	}
}
