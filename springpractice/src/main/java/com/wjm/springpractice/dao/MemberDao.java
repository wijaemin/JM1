package com.wjm.springpractice.dao;

import java.util.List;

import com.wjm.springpractice.dto.MemberBlockDto;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.dto.MemberListDto;
import com.wjm.springpractice.dto.StatDto;
import com.wjm.springpractice.vo.PaginationVO;

//메소드 명세만 작성하기(책으로 치면 목차)
public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String email);
	boolean updateLoginAt(String email);
	boolean changePw(String email, String password);
	boolean changeInfo(MemberDto memberDto);
	boolean exit(String email);
	
	boolean updatePoint(String email, int point);
	boolean updateMemberInfoByAdmin(MemberDto memberDto);
	
	
	//관리자 페이지에서 사용하기 위한 코드들
	int countList(PaginationVO vo);
	List<MemberDto> selectListByPage(PaginationVO vo);
	List<MemberListDto> selectListByPage2(PaginationVO vo);
	
	//회원 차단 코드
	
	void insertBlock(String email);
	boolean deleteBlock(String email);
	
	List<MemberBlockDto> selectBlockList();
	MemberBlockDto selectBlockOne(String email);
	
	
	MemberDto selectOneByNickname(String nickname);
	
	//통계
	List<StatDto> selectGroupByRank();
}
