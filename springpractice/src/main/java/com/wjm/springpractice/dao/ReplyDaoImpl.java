package com.wjm.springpractice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.ReplyDto;
import com.wjm.springpractice.mapper.ReplyMapper;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	
	
	@Override
	public int sequence() {
		String sql="select reply_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	@Override
	public void insert(ReplyDto replyDto) {
		String sql="insert into reply(no, writer, content, "
				+ "origin) values(?,?,?,?)";
		Object[] data= {
				replyDto.getNo(), replyDto.getWriter(), 
				replyDto.getContent(), replyDto.getOrigin()
		};
		jdbcTemplate.update(sql,data);
	}
}
