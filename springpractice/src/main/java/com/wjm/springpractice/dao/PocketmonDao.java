package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.AttachDto;
import com.wjm.springpractice.dto.PocketmonDto;

public interface PocketmonDao {
	int sequence();
	void insert(PocketmonDto pocketmonDto);
	PocketmonDto selectOne(int no);
	List<PocketmonDto>selectList();
	
	void connect(int pocketmonNo, int attachNo);
	AttachDto findImage(int pocketmonNo);
	boolean delete(int no);
	boolean update(PocketmonDto pocketmonDto);
}
