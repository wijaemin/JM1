package com.wjm.springpractice.dao;

import com.wjm.springpractice.dto.CertDto;

public interface CertDao {
	void insert(CertDto certDto);
	boolean delete(String email);
	CertDto selectOne(String email);
}
