package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardListDto;
import com.wjm.springpractice.mapper.BoardListMapper;
import com.wjm.springpractice.mapper.BoardMapper;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardListMapper boardListMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int sequence() {
		String sql="select board_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	@Override
	public void insert(BoardDto boardDto) {
		String sql="insert into board(no, writer, title, content) values(?, ?, ?, ?)";
		Object[] data= {
				boardDto.getNo(), boardDto.getWriter(), 
				boardDto.getTitle(), boardDto.getContent()
		};
		jdbcTemplate.update(sql,data);
		
	}
	@Override
	public List<BoardListDto> selectList() {
		String sql="select * from board_list order by no asc";
		
		return jdbcTemplate.query(sql, boardListMapper);
	}
	@Override
	public BoardDto selectOne(int no) {
		String sql="select * from board where no=?";
		Object[] data= {no};
		
		List<BoardDto> list=jdbcTemplate.query(sql, boardMapper,data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean edit(BoardDto boardDto) {
		String sql="update board set title=?, content=?, updated_at=sysdate where no=?";
		Object[] data= {
				boardDto.getTitle(), boardDto.getContent(), boardDto.getNo()
		};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean delete(int no) {
		String sql="delete board where no=?";
		Object[] data= {no};
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean updateReadcount(int no) {
		String sql="update board set readcount=readcount+1 where no=?";
		Object[] data = {no};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public Integer selectMaxNo(String writer) {
		String sql="select max(no) from board where writer=?";
		Object[] data= {writer};
		
		return jdbcTemplate.queryForObject(sql, Integer.class, data);
	}
	
	@Override
	public List<BoardListDto> selectList(String type, String keyword) {
		String sql="select * from board_list "
				+ "where instr(" + type + ",?) >0 "
				+ "order by no desc";
		Object[] data= {keyword};
		
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
}
