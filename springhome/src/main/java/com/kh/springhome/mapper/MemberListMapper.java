package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.MemberListDto;

@Component
public class MemberListMapper implements RowMapper<MemberListDto>{

	@Override
	public MemberListDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberListDto memberListDto = new MemberListDto();
		memberListDto.setMemberId(rs.getString("member_id"));
		memberListDto.setMemberNickname(rs.getString("member_nickname"));
		memberListDto.setMemberContact(rs.getString("member_contact"));
		memberListDto.setMemberEmail(rs.getString("member_email"));
		memberListDto.setMemberBirth(rs.getString("member_birth"));
		memberListDto.setMemberLevel(rs.getString("member_level"));
		return memberListDto;
	}

}
