package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.MemberBlockDto;

@Component
public class MemberBlockMapper implements RowMapper<MemberBlockDto>{

	@Override
	public MemberBlockDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBlockDto memberBlockDto = new MemberBlockDto();
		memberBlockDto.setEmail(rs.getString("email"));
		memberBlockDto.setBlockTime(rs.getDate("block_time"));
		
		return memberBlockDto;
	}

	
}
