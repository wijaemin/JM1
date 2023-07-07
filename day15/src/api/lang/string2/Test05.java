package api.lang.string2;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//형식은 연도4자리+대시+월2자리+대시+일 2자리로 구성
		//연도는 1900년부터2099년까지만 가능
		//월은 01부터12까지만
		//일은 난이도에 따라 다음과 같이 처리
		//하-무조건 31일까지
		//중-큰달,작은달을 구분하여 처리(2월은29일로 간주)
		//상-윤년을 고려하여 처리
		Scanner sc= new Scanner(System.in);
		System.out.print("생년월일을 입력하세요(YYYY-MM-DD) : ");
		String birth=sc.next();
		
		String regex ="^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		
		if(birth.matches(regex)) {
			System.out.println("설정 완료 되었습니다.");
		}
		else {
			System.out.println("생년월일을 다시 입력해주세요");
		}
	}
}
