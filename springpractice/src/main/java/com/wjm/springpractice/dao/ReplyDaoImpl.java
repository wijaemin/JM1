package com.wjm.springpractice.dao;

import java.util.List;

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
	
	@Override
	public List<ReplyDto> selectList(int origin) {
		String sql="select * from reply where origin = ? "
				+ "order by no asc";
			
		Object[] data = {origin};
		
		return jdbcTemplate.query(sql, replyMapper, data);
	}
	
	@Override
	public ReplyDto selectOne(int no) {
		String sql="select * from reply where no=?";
		Object[] data= {no};
		List<ReplyDto>list= jdbcTemplate.query(sql, replyMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public boolean delete(int no) {
		String sql="delete reply where no = ?";
		Object[]data = {no};
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public boolean edit(ReplyDto replyDto) {
		String sql="update reply set content=? where no=?";
		Object[]data= {replyDto.getContent(), replyDto.getNo()};
		
		return jdbcTemplate.update(sql,data)>0;
	}
}
