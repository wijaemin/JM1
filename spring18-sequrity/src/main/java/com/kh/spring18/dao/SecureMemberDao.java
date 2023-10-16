package com.kh.spring18.dao;

import com.kh.spring18.dto.SecureMemberDto;

//추상화구조-결합도를 낮추기위해
public interface SecureMemberDao {
	void insert(SecureMemberDto dto); 
}
