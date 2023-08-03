package com.kh.spring10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ShirtDto;
import com.kh.spring10.mapper.ShirtMapper;

@Repository
public class ShirtDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ShirtMapper mapper;

	public void insert(ShirtDto dto) {
		String sql="insert into shirt(shirt_no, shirt_name, shirt_color, "
				+ "shirt_price, shirt_kind, shirt_type, shirt_material, shirt_stock) "
				+ "values(shirt_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[]data= {dto.getShirtName(), dto.getShirtColor(), 
				dto.getShirtPrice(), dto.getShirtKind(), dto.getShirtType(), 
				dto.getShirtMaterial(), dto.getShirtStock()};
		jdbcTemplate.update(sql,data);
	}

}
