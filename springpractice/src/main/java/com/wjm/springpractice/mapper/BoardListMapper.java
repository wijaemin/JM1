package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.BoardListDto;

@Component
public class BoardListMapper implements RowMapper<BoardListDto>{

	@Override
	public BoardListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardListDto boardListDto = new BoardListDto();
			boardListDto.setNickname(rs.getString("nickname"));
			boardListDto.setNo(rs.getInt("no"));
			boardListDto.setWriter(rs.getString("writer"));
			boardListDto.setTitle(rs.getString("title"));
			boardListDto.setReadcount(rs.getInt("readcount"));
			boardListDto.setLikecount(rs.getInt("likecount"));
			boardListDto.setReplycount(rs.getInt("replycount"));
			boardListDto.setCreatedAt(rs.getDate("created_at"));
			boardListDto.setUpdatedAt(rs.getDate("updated_at"));
		return boardListDto;
	}

}
