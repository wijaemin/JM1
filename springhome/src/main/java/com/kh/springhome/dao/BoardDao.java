package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardListDto;

public interface BoardDao {
	
	int sequence();
	void insert(BoardDto boardDto);
	BoardDto selectOne(int boardNo);
	boolean delete(int boardNo);
	boolean update(BoardDto boardDto);
	boolean readecountPlus(int boardNo);
	Integer selectMax(String boardWriter);
	
	List<BoardListDto>selectList();
	List<BoardListDto>searchList(String type, String keyword);
}
