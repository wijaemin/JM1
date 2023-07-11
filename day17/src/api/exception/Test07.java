package api.exception;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		//예외 처리하다보니 발생하는 문제점들을 추가적으로 해결
		//[1]예외 처리 하기 전 메세지(stack trace)를 보고싶어요
//		->e.printStackTrace();
//		->개발 완료 후 삭제하거나 다른 코드로 전환 
//		[2]예외 처리 중 발생하는 경고를 없애고 싶어요	
		try{//플랜A
			Scanner sc= new Scanner(System.in);
				
			System.out.print("금액 : ");
			int money =sc.nextInt();
			if(money<0) {
			throw new Exception("금액이 음수일 수 없습니다");
			}
			System.out.print("인원 : ");
			int people =sc.nextInt();
			if(people<0) {
				throw new Exception("인원은 음수	일 수 없습니다");
			}
			sc.close();
				
			int price =money/people; //1인당 정산금액
			int remain=money%people;
				
			System.out.println("1인당 내야할 금액은 " + price + "원입니다.");
			System.out.println(remain + "원은 저희가 지원해 드려요!");
		}
		catch(Exception e){
				e.printStackTrace();//예외처리 안한것처럼 스택추적결과를 출력
			if(e.getMessage()==null) {
				System.err.println("오류발생");
			}
			else {
				System.err.println(e.getMessage());
			}
		}
	}
}
