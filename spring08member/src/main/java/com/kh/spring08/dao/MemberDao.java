package com.kh.spring08.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring08.dto.MemberDto;
import com.kh.spring08.mapper.MemberMapper;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private MemberMapper mapper;
	
	//C회원 정보 추가 
	public void insert(MemberDto dto) {
		String sql="insert into member(member_id, member_pw, "
				+ "member_nickname, member_birth, member_email, "
				+ "member_contact) "
				+ "values(?,?,?,?,?,?)";
		Object[] data= {dto.getMemberId(), dto.getMemberPw(), dto.getMemberNickname(), 
			dto.getMemberBirth(), dto.getMemberEmail(), dto.getMemberContact() };
		jdbcTemplate.update(sql,data);
	}
	//회원 비밀번호 변경
	public boolean updatePw(MemberDto dto) {
		String sql="update member set member_pw =? where member_id =?";
		Object[]data= {dto.getMemberPw(),dto.getMemberId()};
		return jdbcTemplate.update(sql,data)>0;
	}
	
	//회원정보 변경
	public boolean updateInfo(MemberDto dto) {
		String sql="update member set member_nickname = ?, member_email = ?, "
				+ "member_contact = ? where member_id= ?";
		Object[]data= {dto.getMemberNickname(), dto.getMemberEmail(), 
				dto.getMemberContact(), dto.getMemberId()};
		return jdbcTemplate.update(sql,data)>0;
	}
	//회원정보 삭제
	public boolean delete(String memberId) {
		String sql="delete member where member_id = ?";
		Object[] data= {memberId};
		return jdbcTemplate.update(sql,data)>0;
	}
	//R회원정보 리스트 조회
	public List<MemberDto>selectList(){
		String sql="select * from member order by member_id asc";
		return jdbcTemplate.query(sql, mapper);
	}
	//R회원정보 상세조회
	public MemberDto selectOne(String memberId) {
		String sql="select * from member where member_id =?";
		Object[] data= {memberId};
		List<MemberDto>list=jdbcTemplate.query(sql,mapper,data);
		return list.isEmpty() ? null:list.get(0);
	}
	
}
