package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.mapper.BoardListMapper;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardListMapper boardListMapper;
	
	@Override
	public List<BoardDto> selectList() {
		String sql="select * from board";
		
		return jdbcTemplate.query(sql, boardListMapper);
	}

}
