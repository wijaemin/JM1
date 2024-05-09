package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardListDto;
import com.wjm.springpractice.vo.PaginationVO;

public interface BoardDao {
	int sequence();
	void insert(BoardDto boardDto);
	BoardDto selectOne(int no);
	boolean edit(BoardDto boardDto);
	boolean delete(int no);
	
	boolean updateReadcount(int no);
	
	Integer selectMaxNo(String writer);
	
	List<BoardListDto> selectList();
	List<BoardListDto> selectList(String type, String keyword);
	
//	List<BoardListDto> selectListByPage(int page);//vo 모듈이 없을 때
//	List<BoardListDto> selectListByPage(String type, String keyword, int page);//vo 모듈이 없을 때
	
	List<BoardListDto> selectListByPage(PaginationVO vo);//vo 모듈이 있을 때
	
	int countList();//vo 모듈이 없을 때
	int countList(String type, String keyword);//vo 모듈이 없을 때
	
	int countList(PaginationVO vo);//vo 모듈이 있을 때
	
	
	
	//특정 사용자가 작성한 글을 조회하는 메소드
	List<BoardListDto> selectListByWriter(String writer);
	
	
	
}
