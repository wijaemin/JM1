package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.MemberBlockDto;
import com.wjm.springpractice.dto.MemberDto;
import com.wjm.springpractice.dto.MemberListDto;
import com.wjm.springpractice.mapper.MemberBlockMapper;
import com.wjm.springpractice.mapper.MemberListMapper;
import com.wjm.springpractice.mapper.MemberMapper;
import com.wjm.springpractice.vo.PaginationVO;


@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private MemberListMapper memberListMapper;
	
	@Autowired
	private MemberBlockMapper memberBlockMapper;
	@Override
	public void insert(MemberDto memberDto) {
		String sql="insert into member(email, password, nickname, contact, "
				+ "birth, post, addr1, addr2) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data= {memberDto.getEmail(), memberDto.getPassword(), 
				memberDto.getNickname(), memberDto.getContact(), 
				memberDto.getBirth(), memberDto.getPost(), memberDto.getAddr1(), 
				memberDto.getAddr2()
		};
		jdbcTemplate.update(sql,data);
		
	}

	@Override
	public MemberDto selectOne(String email) {
		String sql="select * from member where email=?";
		Object[] data= {email};
		List<MemberDto> list= jdbcTemplate.query(sql, memberMapper,data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean updateLoginAt(String email) {
		String sql="update member set login_at =sysdate where email=?";
		Object[] data= {email};
		
		return jdbcTemplate.update(sql, data)>0;
	}
	
	@Override
	public boolean changePw(String email, String password) {
		String sql="update member set password=? where email=?";
		Object[] data= {password, email};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public boolean changeInfo(MemberDto memberDto) {
		String sql="update member set nickname=?, contact=?, "
				+ "post=?, addr1=?, addr2=? where email=?";
		Object[] data= {memberDto.getNickname(), memberDto.getContact(), 
						memberDto.getPost(), memberDto.getAddr1(),
						memberDto.getAddr2(), memberDto.getEmail()
						};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public boolean exit(String email) {
		String sql="delete member where email=?";
		Object[] data= {email};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public boolean updatePoint(String email, int point) {
		String sql="update member set point=point+? where email=?";
		Object[] data = {point, email};
		
		return jdbcTemplate.update(sql,data)>0;

	}
	
	@Override
	public int countList(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql="select count(*) from member "
					+ "where instr(" + vo.getType() + ",?)>0";
			Object[] data= {vo.getKeyword()};
			
			return jdbcTemplate.queryForObject(sql, int.class,data);
		}
		else {
			String sql="select count(*) from member";
			
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		
	}
	
	@Override
	public List<MemberDto> selectListByPage(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from member "
					+ "where instr(" + vo.getType() + ",?)>0 "
					+ "and rank !='관리자' "
					+ "order by " + vo.getType() + " asc"
					+ ")TMP"
					+ ")where rn between ? and ?";
			Object[] data= {
					vo.getKeyword(),
					vo.getStartRow(),
					vo.getFinishRow()
					};
			return jdbcTemplate.query(sql, memberMapper, data);
		}
		else {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from member "
					+ "where rank !='관리자' "
					+ "order by email asc"
					+ ")TMP"
					+ ")where rn between ? and ?";
			Object[] data= {vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberMapper, data);
		}
	}
	
	@Override
	public boolean updateMemberInfoByAdmin(MemberDto memberDto) {
			String sql="update member set "
					+ "nickname=?, contact=?, post=?, addr1=?, "
					+ "addr2=?, rank=?, point=? where email=?";
			Object[] data= {memberDto.getNickname(), memberDto.getContact(), 
					memberDto.getPost(), memberDto.getAddr1(), memberDto.getAddr2(), 
					memberDto.getRank(), memberDto.getPoint(), memberDto.getEmail()
					};
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public void insertBlock(String email) {
		String sql= "insert into member_block(email) values(?)";
		Object[] data= {email};
		jdbcTemplate.update(sql,data);
	}
	
	@Override
	public boolean deleteBlock(String email) {
		String sql="delete member_block where email=?";
		Object[] data = {email};
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public List<MemberListDto> selectListByPage2(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from member_list "
					+ "where instr(" + vo.getType() + ",?)>0 "
					+ "and rank !='관리자' "
					+ "order by " + vo.getType() + " asc"
					+ ")TMP"
					+ ")where rn between ? and ?";
			Object[] data= {
					vo.getKeyword(),
					vo.getStartRow(),
					vo.getFinishRow()
					};
			return jdbcTemplate.query(sql, memberListMapper, data);
		}
		else {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from member_list "
					+ "where rank !='관리자' "
					+ "order by email asc"
					+ ")TMP"
					+ ")where rn between ? and ?";
			Object[] data= {vo.getStartRow(), vo.getFinishRow()};
			return jdbcTemplate.query(sql, memberListMapper, data);
		}
	}
	
	@Override
	public List<MemberBlockDto> selectBlockList() {
		String sql= "select * from member_block order by block_time asc";
		
		return jdbcTemplate.query(sql, memberBlockMapper);
	}
	
	@Override
	public MemberBlockDto selectBlockOne(String email) {
		String sql="select * from member_block where email=?";
		Object[] data = {email};
		List<MemberBlockDto> list= jdbcTemplate.query(sql, memberBlockMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public MemberDto selectOneByNickname(String nickname) {
		String sql = "select * from member where nickname = ?";
		Object[] data= {nickname};
		List<MemberDto> list= jdbcTemplate.query(sql, memberMapper,data);
		return list.isEmpty() ? null : list.get(0);
	}
}
