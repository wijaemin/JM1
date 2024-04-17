package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wjm.springpractice.dto.BoardDto;

public class BoardMapper implements RowMapper<BoardDto> {

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(rs.getInt("no"));
		boardDto.setWriter(rs.getString("writer"));
		boardDto.setTitle(rs.getString("title"));
		boardDto.setReadcount(rs.getInt("readcount"));
		boardDto.setLikecount(rs.getInt("likecount"));
		boardDto.setReplycount(rs.getInt("replycount"));
		boardDto.setCreatedAt(rs.getDate("createdAt"));
		boardDto.setUpdatedAt(rs.getDate("updatedAt"));
		return boardDto;
	}

}
