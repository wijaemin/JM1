package api.lang.string;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);

		
		System.out.print("아이디 입력 : ");
		String id=sc.next();
		
		//id=id.toLowerCase();
		
		System.out.print("비밀번호 입력 : ");
		String password=sc.next();
		
		
		
		
		boolean isLogin =id.toLowerCase().equals("khacademy") && password.equals("student1234");
		if(isLogin) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("실패");
		}
	
		
		
		
		
		
		
		
		
		
		
	}
}
