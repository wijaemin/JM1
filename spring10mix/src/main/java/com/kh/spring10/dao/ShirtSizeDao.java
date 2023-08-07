package com.kh.spring10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ShirtSizeDto;
import com.kh.spring10.mapper.ShirtSizeMapper;

@Repository
public class ShirtSizeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ShirtSizeMapper mapper;
	
	public void insert(ShirtSizeDto dto) {
		String sql="insert into shirt_size(shirt_no, shirt_size_name) "
				+ "values(?,?)";
		Object[]data= {dto.getShirtNo(),dto.getShirtSizeName()};
		jdbcTemplate.update(sql,data);
	}
}
