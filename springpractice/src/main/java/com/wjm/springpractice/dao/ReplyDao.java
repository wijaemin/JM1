package com.wjm.springpractice.dao;

import com.wjm.springpractice.dto.ReplyDto;

public interface ReplyDao {
	int sequence();
	void insert(ReplyDto replyDto);
}
