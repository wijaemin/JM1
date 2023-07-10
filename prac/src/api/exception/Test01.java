package api.exception;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//예외(Exception)
		//- 실행 중 발생하는 돌발상황
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money= sc.nextInt();
		System.out.print("인원수 : ");
		int people=sc.nextInt();
		
		sc.close();
		
		int price =money/people;
		int remain =money%people;
		
		System.out.println("1인당 내야할 금액은 : " + price + "원");
		System.out.println(remain + "원은 저희가 내드립니다.");
	}
}
