package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.CertDto;
import com.wjm.springpractice.mapper.CertMapper;

@Repository
public class CertDaoImpl implements CertDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private CertMapper certMapper;
	
	@Override
	public void insert(CertDto certDto) {
		String sql="insert into cert(email, num) values(?,?)";
		Object[] data= {certDto.getEmail(),certDto.getNum()};
		jdbctemplate.update(sql,data);
	}
	
	@Override
	public boolean delete(String email) {
		String sql="delete cert where email=?";
		Object[] data= {email};
		
		return jdbctemplate.update(sql,data)>0;
	}
	
	@Override
	public boolean deleteOver5min() {
		String sql="delete cert where time < sysdate-5/24/60";
		return jdbctemplate.update(sql)>0;
	}
	
	@Override
	public CertDto selectOne(String email) {
		String sql="select * from cert where email=?";
		Object[] data= {email};
		List<CertDto> list= jdbctemplate.query(sql, certMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	@Override
	public CertDto selectOneIn5min(String email) {
		String sql="select * from cert where email=? and "
				+ "time between sysdate-5/24/60 and sysdate";
		Object[] data= {email};
		List<CertDto> list= jdbctemplate.query(sql, certMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
}
