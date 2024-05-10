package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.dto.MemberListDto;

@Component
public class MemberListMapper implements RowMapper<MemberListDto> {

	@Override
	public MemberListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberListDto memberListDto = new MemberListDto();
		memberListDto.setEmail(rs.getString("email"));
		memberListDto.setPassword(rs.getString("password"));
		memberListDto.setNickname(rs.getString("nickname"));
		memberListDto.setContact(rs.getString("contact"));
		memberListDto.setBirth(rs.getString("birth"));
		memberListDto.setPost(rs.getString("post"));
		memberListDto.setAddr1(rs.getString("addr1"));
		memberListDto.setAddr2(rs.getString("addr2"));
		memberListDto.setRank(rs.getString("rank"));
		memberListDto.setPoint(rs.getInt("point"));
		memberListDto.setJoinAt(rs.getDate("join_at"));
		memberListDto.setLoginAt(rs.getDate("login_at"));
		memberListDto.setBlock(rs.getString("block"));
		
		return memberListDto;
	}

}
