package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.ReplyDto;

public interface ReplyDao {
	int sequence();
	void insert(ReplyDto replyDto);
	List<ReplyDto> selectList(int origin);
	ReplyDto selectOne(int no);
	boolean delete(int no);
	
}
