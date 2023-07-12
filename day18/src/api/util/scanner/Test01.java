package api.util.scanner;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//Scanner클래스
		//=문자열 입력 및 분석 클래스
		//=키보드 입력은 기능 중 일부분일뿐
		//=파일 뿐 아니라 홈페이지도 읽어올 수 있다(웹 크롤링)
		
		
		String sample ="떳다떳다 비행기 \n날아라 날아라 \n떳다떳다 비행기 \n우리비행기";
		//System.out.println(sample);
		
		//[1]단어별로 잃기 .next() 띄어쓰기나 개행 등 공백이 기준
		//[2]줄별로 읽기 .nextLine() 개행 문자 기준
	
		Scanner sc= new Scanner(sample);
		
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.next());
		//System.out.println(sc.next())// 에러(개수초과)
		sc.close();
		
		
		
		
		
		
		
	}
}
