package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.JdbcUtils;

public class MemberDao {
	public void insert(MemberDto dto) {
		String sql="insert into Member(member_id, member_pw, "
				+ "member_nickname, member_birth, member_contact) "
				+ "values(?,?,?,?,?)";
		Object[]data= {dto.getMemberId(),dto.getMemberPw(), 
				dto.getMemberNickname(),dto.getMemberBirth(), 
				dto.getMemberContact()};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		
	}
	
	//비밀번호 변경 기능
	// - 기존비밀번호와 신규비밀번호를 입력받아 검사 후 변경(권장하진 않음)
	// - 임시비밀번호 변경하는 기능
	// - 아이디에 맞는 계정의 비밀번호를 변경하는 기능
	
	// public
	public boolean updateMemberPassword(MemberDto dto) {
		String sql="update member set member_pw=? where member_id =?";
		Object[]data= {dto.getMemberPw(),dto.getMemberId()};
		
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		int result=jdbcTemplate.update(sql, data);
		return result>0;
	}
	public boolean updateMemberInfo(MemberDto dto) {
		String sql="update member set member_nickname =?, "
				+ "member_contact=?, member_email =?, member_birth =? "
				+ "where member_id=?";
		Object[] data = {dto.getMemberNickname(), dto.getMemberContact(), 
				dto.getMemberEmail(), dto.getMemberBirth(), dto.getMemberId()
		};
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		int result=jdbcTemplate.update(sql,data);
		return result>0;
		
	}
	public boolean delete(String memberId) {
		String sql="delete member where member_id =?";
		Object[]data= {memberId};
		JdbcTemplate jdbcTemplate= JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.update(sql,data)>0;
	}
	
	
	
	public MemberMapper mapper =new MemberMapper();
	
	//(R)목록
	public List<MemberDto> selectList(){
		String sql="select * from Member";
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		List<MemberDto>list=jdbcTemplate.query(sql, mapper);
		return list;
	}
	//(R)상세
	public MemberDto selectOne(String memberId) {
		String sql="select * from member where member_id=?";
		Object[]data = {memberId};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		List<MemberDto> list=jdbcTemplate.query(sql, mapper,data);
		return list.isEmpty() ? null:list.get(0);
	}
	
	
	
	public List<MemberDto> selectListByPage(int page,int size){
		int end=page*size;
		int begin=end-(size-1);
		
		String sql="select * from( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from member order by member_id desc"
				+ ")TMP"
				+ ")where rn between ? and ?";
		Object[] data= {begin,end};
		JdbcTemplate jdbcTemplate= JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.query(sql, mapper,data);
		
		
	}
				
	
	
}
