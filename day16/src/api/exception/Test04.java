package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test04 {
	public static void main(String [] args) {
		//예외 처리 구문
	//	try {
	//		플랜A코드
	//	}
	//	catch{
	//		플랜B코드
	//	}
		
		try{
			Scanner sc= new Scanner(System.in);
		
			System.out.print("금액 : ");
			int money =sc.nextInt();
			System.out.print("인원 : ");
			int people =sc.nextInt();
		
			sc.close();
		
			int price =money/people; //1인당 정산금액
			int remain=money%people;
		
			System.out.println("1인당 내야할 금액은 " + price + "원입니다.");
			System.out.println(remain + "원은 저희가 지원해 드려요!");
		}
		catch(Exception e){
			//catch(Throwable e)//예외의 할아버지
			//플랜B.입력을 잘못했을 때
			System.err.println("프로그램 오류 발생");
		}
		
		
	
	}
}
