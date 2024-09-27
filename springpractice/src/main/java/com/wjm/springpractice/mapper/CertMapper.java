package com.wjm.springpractice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.wjm.springpractice.dto.CertDto;

@Component
public class CertMapper implements RowMapper<CertDto>{

	@Override
	public CertDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CertDto certDto = new CertDto();
		certDto.setEmail(rs.getString("email"));
		certDto.setNum(rs.getString("num"));
		certDto.setTime(rs.getDate("time"));
		return certDto;
	}

}
