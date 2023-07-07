package api.lang.string2;

import java.util.Scanner;

public class Test07 {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		
		Member wi=new Member();
		System.out.print("회원아이디 입력 : ");
		wi.memberId=sc.next();
		System.out.print("회원비밀번호 입력 : ");
		wi.memberPw=sc.next();
		System.out.print("회원 이름 입력 :");
		wi.memberName=sc.next();
		
		wi.show();
	}
}
