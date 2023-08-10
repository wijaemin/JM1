package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;

public interface BoardDao {
	
	int sequence();
	void insert(BoardDto dto);
	List<BoardDto>selectList();
}
