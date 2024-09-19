package com.wjm.springpractice.dao;

import com.wjm.springpractice.dto.AttachDto;

public interface AttachDao {
	int sequence();
	void insert(AttachDto attachDto);
	boolean delete(int attachNo);
	AttachDto selectOne(int attachNo);
}
