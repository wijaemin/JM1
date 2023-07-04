package oop.keyword6;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		System.out.print("아이디 : ");
		String id=sc.next();
		System.out.print("비밀번호 : ");
		String password =sc.next();
		System.out.print("닉네임 : ");
		String nickname=sc.next();
		
		UserInfo u1= new UserInfo(id, password, nickname);
		u1.show();
	}
}
