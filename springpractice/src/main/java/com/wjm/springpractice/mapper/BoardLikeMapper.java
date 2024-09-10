package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.BoardLikeDto;

@Component
public class BoardLikeMapper implements RowMapper<BoardLikeDto>{

	@Override
	public BoardLikeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardLikeDto boardLikeDto = new BoardLikeDto();
		boardLikeDto.setEmail(rs.getString("email"));
		boardLikeDto.setNo(rs.getInt("no"));
		return boardLikeDto;
	}
}
