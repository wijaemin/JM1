package com.wjm.springpractice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dao.BoardLikeDao;
import com.wjm.springpractice.dto.BoardLikeDto;
import com.wjm.springpractice.vo.BoardLikeVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RequestMapping("/rest/like")
@RestController
public class BoardLikeRestController {
	
	@Autowired
	private BoardLikeDao boardLikeDao;
	
	@Autowired
	private BoardDao boardDao;

	//만들어야 하는 기능
	//[1] 좋아요 설정/해제를 수행하는 매핑 - 사용자가 하트 클릭시 처리
	//[2] 좋아요 상태를 확인하는 매핑 - 사용자 최초 화면에 표시할 하트 확인
	
	@RequestMapping("/check")
	public BoardLikeVO check(@ModelAttribute BoardLikeDto boardLikeDto, 
						HttpSession session) {
		
		String email=(String)session.getAttribute("email");
		boardLikeDto.setEmail(email);
		boolean isCheck = boardLikeDao.check(boardLikeDto);
		int count =boardLikeDao.count(boardLikeDto.getNo());
		
		boardDao.updateBoardLikecount(boardLikeDto.getNo(), count);
		BoardLikeVO vo=new BoardLikeVO();
		vo.setCheck(isCheck);
		vo.setCount(count);
		
		return vo;
	}
	
	@RequestMapping("/action")
	public BoardLikeVO action(@ModelAttribute BoardLikeDto boardLikeDto, 
						HttpSession session) {
		String email=(String)session.getAttribute("email");
		boardLikeDto.setEmail(email);
		boolean isCheck = boardLikeDao.check(boardLikeDto);
		
		if(isCheck) {//체크되어있으면
			//체크 해제
			boardLikeDao.delete(boardLikeDto);//체크 해제
		}
		else {//안되어있으면
			//체크 설정
			boardLikeDao.insert(boardLikeDto);//체크 설정
		}
		int count =boardLikeDao.count(boardLikeDto.getNo());
		boardDao.updateBoardLikecount(boardLikeDto.getNo(), count);
		BoardLikeVO vo= new BoardLikeVO();
		vo.setCheck(!isCheck);
		vo.setCount(count);
		
		return vo;
	}
	
}
