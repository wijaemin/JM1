package api.lang.string;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//사용자에게 프로그램 내에서 사용할 닉네임을 입력받도록 구현
		//단,다음과 같은 상황일 경우 오류 메세지를 출력
		
		//닉네임이 2글자 이상 10글자 이하가 아닌 경우
		//닉네임에 '운영자'라는 단어가 포함된 경우
		Scanner sc= new Scanner(System.in);
		
		System.out.print("닉네임을 입력하세요 : ");
		String nickname= sc.next();
		
		boolean length=nickname.length()>=2&&nickname.length()<=10;
		boolean contain=nickname.contains("운영자");
		if(length){
			if(contain) {
				System.out.println("오류");
			}
			else {
				System.out.println("닉네임 설정이 완료되었습니다");
			}
		}
		else {
			System.out.println("오류");
		}
	}
}
