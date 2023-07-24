package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04 {
	public static void main(String[] args) {
		MemberDto dto =new MemberDto();
		dto.setMemberId("minialp020513");
		dto.setMemberPw("Jm720613!!");
		dto.setMemberNickname("안녕하세요");
		dto.setMemberBirth("1972-06-13");
		dto.setMemberContact("01012344321");
		MemberDao dao= new MemberDao();
		dao.insert(dto);
		System.out.println("등록완료");
		
	}
}
