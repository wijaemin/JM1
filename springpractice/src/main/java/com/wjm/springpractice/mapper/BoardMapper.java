package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto> {

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(rs.getInt("no"));
		boardDto.setWriter(rs.getString("writer"));
		boardDto.setTitle(rs.getString("title"));
		boardDto.setContent(rs.getString("content"));
		boardDto.setReadcount(rs.getInt("readcount"));
		boardDto.setLikecount(rs.getInt("likecount"));
		boardDto.setReplycount(rs.getInt("replycount"));
		boardDto.setCreatedAt(rs.getDate("created_at"));
		boardDto.setUpdatedAt(rs.getDate("updated_at"));
		return boardDto;
	}

}
