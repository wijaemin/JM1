package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;

public interface BoardDao {
	
	int sequence();
	void insert(BoardDto boardDto);
	List<BoardDto>selectList();
	BoardDto selectOne(int boardNo);
	boolean delete(int boardNo);
	boolean update(BoardDto boardDto);
	boolean readecountPlus(int boardNo);
	List<BoardDto>searchList(String type, String keyword);
}
