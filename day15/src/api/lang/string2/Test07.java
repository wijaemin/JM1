package api.lang.string2;

import java.util.Scanner;

public class Test07 {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		
		
		System.out.print("회원아이디 입력 : ");
		String memberId=sc.next();
		System.out.print("회원비밀번호 입력 : ");
		String memberPw=sc.next();
		System.out.print("회원 이름 입력 :");
		String memberName=sc.next();
		
		Member m1=new Member(memberId,memberPw,memberName);
		m1.show();
		
		sc.close();
	}
}
