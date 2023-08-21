package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;
import com.kh.springhome.vo.PaginationVO;

public interface AdminDao {
	MemberDto selectOne(String memberId);
//	List<MemberListDto>selectListByPage(int page);
//	List<MemberListDto>selectListByPage(String type, String keyword, int page);
	List<MemberListDto>selectListByPage(PaginationVO vo);
	
	int countList(PaginationVO vo);
}
