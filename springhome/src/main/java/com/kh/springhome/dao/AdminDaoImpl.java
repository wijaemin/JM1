package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;
import com.kh.springhome.mapper.MemberListMapper;
import com.kh.springhome.mapper.MemberMapper;
import com.kh.springhome.vo.PaginationVO;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private MemberListMapper listMapper;

	@Autowired
	private MemberMapper memberMapper;
//	@Override
//	public List<MemberListDto> selectListByPage(PaginationVO vo) {
//		if (vo.isSearch()) {
//			return selectListByPage(vo.getType(), vo.getKeyword(), vo.getPage());
//		}
//		else {
//			return selectListByPage(vo.getPage());
//		}
//	}
	
// 강사님 방식
	@Override
	public List<MemberListDto> selectListByPage(PaginationVO vo) {
		if (vo.isSearch()) {
		String sql="select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select * from member where instr(" +vo.getType()+",?)>0 "
							+ "order by " + vo.getType() + " asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data= {vo.getKeyword(),vo.getStartRow(),vo.getFinishRow()};
			
			return jdbcTemplate.query(sql, listMapper, data);
		}
		else {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from ("
					+ "select * from member "
					+ "order by member_id asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data= {vo.getStartRow(),vo.getFinishRow()};
			return jdbcTemplate.query(sql, listMapper,data);
		}
	}

//	@Override
//	public List<MemberListDto> selectListByPage(int page) {
//		int end= page * 10;
//		int begin = end -9;
//		String sql="select * from ("
//				+ "select rownum rn, TMP.* from ("
//				+ "select * from member"
//				+ ")TMP"
//				+ ") where rn between ? and ?";
//		Object[] data= {begin,end};
//		return jdbcTemplate.query(sql, listMapper,data);
//	}
//
//	@Override
//	public List<MemberListDto> selectListByPage(String type, String keyword, int page) {
//		int end=page * 10;
//		int begin = end-9;
//		
//		String sql="select * from ("
//				+ "select rownum rn, TMP.* from ("
//				+ "select * from member where instr(" +type+",?)>0"
//				+ ")TMP"
//				+ ") where rn between ? and ?";
//		Object[] data= {keyword,begin,end};
//		
//		return jdbcTemplate.query(sql, listMapper, data);
//	}
	
	@Override
	public int countList(PaginationVO vo) {
		if (vo.isSearch()) {
			String sql="select count(*) from member " 
		+ "where instr(" + vo.getType() + ",?)>0";
		
			Object[]data = {vo.getKeyword()};
			
			return jdbcTemplate.queryForObject(sql, int.class,data);
	}
		else {
			String sql= "select count(*) from member";
			
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}

	@Override
	public MemberDto selectOne(String memberId) {
		String sql="select * from member where member_id =?";
		Object[]data= {memberId};
		List<MemberDto>list=jdbcTemplate.query(sql, memberMapper,data);
		return list.isEmpty()? null:list.get(0);
	}

}