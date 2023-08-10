package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.mapper.BoardListMapper;
import com.kh.springhome.mapper.BoardMapper;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardListMapper listMapper;
	
	
	@Override
	public int sequence() {
		String sql="select board_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public void insert(BoardDto dto) {
		String sql="insert into board(board_no, board_writer, board_title, "
				+ "board_content) values(?, ?, ?, ?)";
		Object[]data= {dto.getBoardNo(),dto.getBoardWriter(), 
				dto.getBoardTitle(),dto.getBoardContent()};
		jdbcTemplate.update(sql,data);
	}

	@Override
	public List<BoardDto> selectList() {
		String sql="select board_no, board_writer, "
				+ "board_title, board_readcount, "
				+ "board_likecount, board_replycount, "
				+ "board_ctime, board_utime "
				+ "from board order by board_no asc";
		
		return jdbcTemplate.query(sql, listMapper);
	}



	

	
	
	
}
