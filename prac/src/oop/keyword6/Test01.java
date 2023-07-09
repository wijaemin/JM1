package oop.keyword6;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		
		User u1= new User("adminuser","admin1234","관리자");
		User u2= new User("student","student1234","수강생");
		User u3= new User("manager","manager1234","매니저");
		
		u1.show();
		u2.show();
		u3.show();
		
		System.out.print("아이디 입력 : ");
		String id=sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw=sc.next();
		System.out.print("닉네임 입력 : ");
		String nickname=sc.next();
		
		User u4 =new User(id,pw,nickname);
		u4.show();
	}
	
	
}
