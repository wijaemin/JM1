package condition3;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
			/* 큰달 /31까지 존재하는달(1,3,5,7,8,10,12월)
			 * 작은달/30일까지 존재하는달(4,6,9,11월)
			 * 2월 / 윤년일경우 29일,아닐경우 28일까지 존재
			 * 사용자에게 월을 입력받아 해당하는 달의 날짜 수를 출력하도록 구현하세요
			 * 단, 2월은 28일까지라고 가정합니다
			 */
		Scanner sc= new Scanner(System.in);
		
		System.out.print("달을 입력하세요 : ");
		int month = sc.nextInt();
		
		System.out.print("년도를 입력하세요 : ");
		int year = sc.nextInt();
		
		int days;
		
		switch(month) {
			case 1, 3, 5, 7, 8, 10, 12:
				days=31;
				break;
			case 4, 6, 9, 11:
				days=30;
				break;
			case 2:
				boolean leapYear= year%400==0 || year%4==0 && year%100!=0;
				if(leapYear) {
				days=29;
				}
				else {
				days=28;
				}
				break;
			default :
				days=0;
				break;
			}
		
			if(days !=0) {
			System.out.println(year + "년 " + month + "월은 " + days + "일까지 존재합니다.");
			}
			else {
			System.out.println("달 값이 잘못되었습니다.");
			}
			sc.close();
	}
}
