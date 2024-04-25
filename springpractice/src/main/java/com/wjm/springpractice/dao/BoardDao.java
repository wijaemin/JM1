package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardListDto;

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
	
	List<BoardListDto> selectListByPage(int page);
	List<BoardListDto> selectListByPage(String type, String keyword, int page);
	
	int countList();
	int countList(String type, String keyword);
	
}
