package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.BoardDto;

public interface BoardDao {
	
	List<BoardDto> selectList();
}
