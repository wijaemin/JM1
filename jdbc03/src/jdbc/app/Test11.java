package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test11 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MemberDto dto= new MemberDto();
		System.out.print("정보를 바꿀 아이디를 입력하세요 : ");
		dto.setMemberId(sc.next());
		System.out.print("바꿀 닉네임을 입력하세요 : ");
		dto.setMemberNickname(sc.next());
		System.out.print("바꿀 생일을 입력하세요 : ");
		dto.setMemberBirth(sc.next());
		System.out.print("바꿀 이메일을 입력하세요 : ");
		dto.setMemberEmail(sc.next());
		System.out.print("바꿀 전화번호를 입력하세요 : ");
		dto.setMemberContact(sc.next());
		MemberDao dao =new MemberDao();
		boolean result=dao.updateMemberInfo(dto);
		
		if(result) System.out.println("변경되었습니다");
		else System.out.println("잘못된 회원입니다.");
	}
}
