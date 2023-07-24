package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MemberDto;
import jdbc.mapper.MemberMapper;
import jdbc.util.JdbcUtils;

public class Test06_1 {
	public static void main(String[] args) {
		//로그인 프로그램
		//=SQL구문: select * from member where member_id=?(권장) (자료형=MemberDto)
		//=SQL구문: select * from member where member_id=? and member_pw=?(권장X)
		
		//=Primary key로 항목을 조회하는 것을 '단일조회'라고 한다
		//=모든 테이블은 단일 조회가 가능해야 한다
		//=단일 조회는 결과가 없거나 한개이다
		
		
		//데이터
		String memberId= "minialp2002";
		String memberPw= "jM720613!!";
		
		//DB처리
//		MemberHelper helper= new MemberHelper();
//		boolean result=helper.login(memberId, memberPw);
//		
//		System.out.println("로그인 결과= " + result);
	}
}
