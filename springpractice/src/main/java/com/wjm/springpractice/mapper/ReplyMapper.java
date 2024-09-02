package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.ReplyDto;

@Component
public class ReplyMapper implements RowMapper<ReplyDto> {
	
	@Override
	public ReplyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReplyDto replyDto = new ReplyDto();
		replyDto.setNo(rs.getInt("no"));
		replyDto.setWriter(rs.getString("writer"));
		replyDto.setContent(rs.getString("content"));
		replyDto.setCreatedAt(rs.getDate("created_at"));
		replyDto.setOrigin(rs.getInt("origin"));
		
		return replyDto;
	}
}
