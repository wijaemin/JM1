package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.PocketmonDto;


@Component//컨트롤러도 아니고 리파지토리도 아닌 애매한놈들
public class PocketmonMapper implements RowMapper<PocketmonDto>{

	@Override
	public PocketmonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PocketmonDto pocketmonDto=new PocketmonDto();
		pocketmonDto.setNo(rs.getInt("no"));
		pocketmonDto.setName(rs.getString("name"));
		pocketmonDto.setType(rs.getString("type"));
		return pocketmonDto;
	}

}
