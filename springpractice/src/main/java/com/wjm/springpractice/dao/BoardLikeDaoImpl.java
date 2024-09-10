package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardLikeDto;
import com.wjm.springpractice.mapper.BoardLikeMapper;
import com.wjm.springpractice.mapper.BoardMapper;

@Repository
public class BoardLikeDaoImpl implements BoardLikeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardLikeMapper boardLikeMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void insert(BoardLikeDto boardLikeDto) {
		String sql="insert into board_like(email, no) values(?,?)";
		Object[] data = {boardLikeDto.getEmail(), boardLikeDto.getNo()};
		
		jdbcTemplate.update(sql,data);
		
	}
	@Override
	public boolean delete(BoardLikeDto boardLikeDto) {
		String sql="delete board_like where email=? and no = ?";
		Object[] data = {boardLikeDto.getEmail(), boardLikeDto.getNo()};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean check(BoardLikeDto boardLikeDto) {
		String sql="select * from board_like where email = ? and no = ?";
		Object[] data = {boardLikeDto.getEmail(), boardLikeDto.getNo()};
		
		List<BoardLikeDto> list= jdbcTemplate.query(sql, boardLikeMapper,data);
		return list.isEmpty() ? false : true;
	}
	
	@Override
	public int count(int no) {
		String sql="select count(*) from board_like where no = ?";
		Object[] data = {no};
		
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	
	@Override
	public List<BoardDto> findByEmail(String email) {
		String sql="select board.* "
				+ "from board_like left outer join board "
				+ "on board_like.no = board.no "
				+ "where board_like.email=? "
				+ "order by board.no desc";
		Object[] data= {email};
		return jdbcTemplate.query(sql,boardMapper ,data);
	}
}
