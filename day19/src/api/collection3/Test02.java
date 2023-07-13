package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test02 {
	public static void main(String[]args) {
//		로그인 프로그램
//
//		제시된 아이디와 비밀번호를 Map에 저장해두고 사용자에게 아이디와 비밀번호를 입력받아 다음과 같이 처리
//
//		아이디	비밀번호
//		admin	admin1234
//		teacher	teacher1234
//		student	student1234
//		manager	manager1234
//		아이디와 비밀번호가 모두 일치할 경우 로그인 성공 출력
//		그 외의 경우는 모두 로그인 실패 출력
		Map<String,String>user =new TreeMap<>();
		user.put("admin", "admin1234");
		user.put("teacher", "teacher1234");
		user.put("student", "student1234");
		user.put("manager", "manager1234");
//		System.out.println(user);
		
		Scanner sc= new Scanner(System.in);
		System.out.print("아이디 입력 : ");
		String id=sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw=sc.next();
		boolean success=user.containsKey(id)&&pw.equals(user.get(id));
		if(success) {
			System.out.println("로그인 성공");
		}
		else System.out.println("로그인 실패");
	}
}
