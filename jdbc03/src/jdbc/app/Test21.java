package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test21 {

	public static void main(String[] args) {
		String memberId="testuser12345";
		MemberDao dao=new MemberDao();
		MemberDto dto=dao.selectOne(memberId);
		List<MemberDto> list=dao.selectList();
		
		if(dto==null) {
			System.out.println("조회하려는 아이디가 없음");
		}
		else {
			System.out.println(dto.getMemberId());
			System.out.println(dto.getMemberPw());
			System.out.println(dto.getMemberNickname());
			System.out.println(dto.getMemberBirth());
			System.out.println(dto.getMemberEmail());
			System.out.println(dto.getMemberContact());
			System.out.println(dto.getMemberLevel());
			System.out.println(dto.getMemberPoint());
			System.out.println(dto.getMemberJoin());
		}
	}

}
