package com.wjm.springpractice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.MemberDto;


@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(MemberDto memberDto) {
		String sql="insert into member(email, password, nickname, contact, "
				+ "birth, post, addr1, addr2) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data= {memberDto.getEmail(), memberDto.getPassword(), 
				memberDto.getNickname(), memberDto.getContact(), 
				memberDto.getBirth(), memberDto.getPost(), memberDto.getAddr1(), 
				memberDto.getAddr2()
		};
		jdbcTemplate.update(sql,data);
		
	}

}
