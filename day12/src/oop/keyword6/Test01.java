package oop.keyword6;

public class Test01 {
	public static void main(String[] args) {
		UserInfo u1=new UserInfo("adminuser","admin1234","관리자");
		UserInfo u2=new UserInfo("student","student1234","수강생");
		UserInfo u3=new UserInfo("manager","manager1234","매니저");
		
		u1.show();
		u2.show();
		u3.show();
		
		
		
	}
}
