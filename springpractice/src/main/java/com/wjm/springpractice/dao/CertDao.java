package com.wjm.springpractice.dao;

import com.wjm.springpractice.dto.CertDto;

public interface CertDao {
	void insert(CertDto certDto);
	boolean delete(String email);
	boolean deleteOver5min();
	CertDto selectOne(String email);
	CertDto selectOneIn5min(String email);
}
