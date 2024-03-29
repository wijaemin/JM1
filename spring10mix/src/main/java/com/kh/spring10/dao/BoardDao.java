package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.mapper.BoardDetailMapper;
import com.kh.spring10.mapper.BoardListMapper;


@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardListMapper listMapper;
	@Autowired
	private BoardDetailMapper detailMapper;
	
	//등록과 번호생성 기능
	//select board_seq.nextval from dual
	//insert into board(...) values(?, ?, ?, ?,0)
	public int sequence() {
		String sql="select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
//		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	
	public void insert(BoardDto dto) {
		String sql="insert into board("
				+ "board_no, board_title, board_content, "
				+ "board_writer, board_readcount"
				+ ")values(?, ?, ?, ?, 0)";
		Object[]data= {
				dto.getBoardNo(),dto.getBoardTitle(), 
				dto.getBoardContent(), dto.getBoardWriter()
		};
		jdbcTemplate.update(sql,data);
	}
	
	
public boolean update(BoardDto dto) {
		String sql="update board "
				+ "set board_title=?, board_content=?, board_writer=? "
				+ "where board_no=?";
		Object[] data= {dto.getBoardTitle(), dto.getBoardContent(),
				dto.getBoardWriter(), dto.getBoardNo()};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
public boolean delete(int boardNo) {
		String sql="delete board where board_no = ?";
		Object[] data= {boardNo};
		return jdbcTemplate.update(sql,data)>0;
	}

	public List<BoardDto>selectList(){
		String sql="select "
				+ "board_no, board_title, "
				+ "board_writer, board_readcount "
				+ "from "
				+ "board order by board_no desc";
		return jdbcTemplate.query(sql, listMapper);
	}
	public BoardDto selectOne(int boardNo) {
        String sql = "select * from board where board_no = ?";
        Object[] data = {boardNo};
        List<BoardDto> list = jdbcTemplate.query(sql, detailMapper, data);
        return list.isEmpty() ? null : list.get(0);
	}
}