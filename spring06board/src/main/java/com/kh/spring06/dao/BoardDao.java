package com.kh.spring06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BoardDto;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(BoardDto dto) {
		String sql="insert into board(board_no, board_title, "
					+ "board_content, board_writer, board_readcount) "
					+ "values(board_seq.nextval,?,?,?,0)";
		Object[] data= {dto.getBoardTitle(), dto.getBoardContent(), 
				dto.getBoardWriter(), dto.getBoardReadcount()};
		jdbcTemplate.update(sql,data);
		
		
	}
}