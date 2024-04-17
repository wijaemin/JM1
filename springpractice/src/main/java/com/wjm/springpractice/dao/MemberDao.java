package com.wjm.springpractice.dao;

import com.wjm.springpractice.dto.MemberDto;

//메소드 명세만 작성하기(책으로 치면 목차)
public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String email);
	boolean updateLoginAt(String email);
	boolean changePw(String email, String password);
	boolean changeInfo(MemberDto memberDto);
	boolean exit(String email);
}
