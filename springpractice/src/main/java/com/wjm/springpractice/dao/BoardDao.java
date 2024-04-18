package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.BoardDto;

public interface BoardDao {
	int sequence();
	void insert(BoardDto boardDto);
	List<BoardDto> selectList();
	BoardDto selectOne(int no);
	boolean edit(BoardDto boardDto);
	boolean delete(int no);
	
	boolean updateReadcount(int no);
}
