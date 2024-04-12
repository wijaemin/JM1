package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.MemberDto;

@Component
public class MemberMapper implements RowMapper<MemberDto> {

	@Override
	public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDto memberDto = new MemberDto();
		memberDto.setEmail(rs.getString("email"));
		memberDto.setPassword(rs.getString("password"));
		memberDto.setNickname(rs.getString("nickname"));
		memberDto.setContact(rs.getString("contact"));
		memberDto.setBirth(rs.getString("birth"));
		memberDto.setPost(rs.getString("post"));
		memberDto.setAddr1(rs.getString("addr1"));
		memberDto.setAddr2(rs.getString("addr2"));
		memberDto.setRank(rs.getString("rank"));
		memberDto.setPoint(rs.getInt("point"));
		memberDto.setJoinAt(rs.getDate("join_at"));
		memberDto.setLoginAt(rs.getDate("login_at"));
		
		return memberDto;
	}

}
