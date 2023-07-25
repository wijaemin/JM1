package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test10 {
	public static void main(String[] args) {
		//비밀번호 변경 프로그램
		
		//데이터 준비
		Scanner sc=new Scanner(System.in);
		
		System.out.print("비밀번호를 바꿀 아이디를 입력하세요 : ");
		String memberId =sc.next();
		System.out.print("변경할 비밀번호를 입력하세요 : ");
		String memberPw=sc.next();
		System.out.print("변경할 비밀번호를 다시 입력하세요 : ");
		String memberPwRe=sc.next();
		if(memberPw.equals(memberPwRe)) {
			MemberDto dto =new MemberDto();
			dto.setMemberId(memberId);
			dto.setMemberPw(memberPwRe);
			MemberDao dao=new MemberDao();
			boolean result=dao.updateMemberPassword(dto);
			if(result)System.out.println("해결완료");
		}
		else System.out.println("변경할 비밀번호와 "
				+ "다시 입력한 비밀번호가 일치하지 않습니다.");
		
		
	}
}
