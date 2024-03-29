package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		/*
		 * 고3 수험생을 대상으로 이벤트를 진행하기 위해 검사하는 프로그램을 만들려고 합니다. 출생년도 입력받아서 19살인 경우 '이벤트 대상입니다'
		 * 출력 아니면 '이벤트 대상이 아닙니다' 출력
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도(ex :2002년 ->2002)를 입력해주세요 = ");
		
		LocalDate now =LocalDate.now();
		
		
		int birth = sc.nextInt();
		int year = now.getYear();
		int age = year-birth+1;
		

		if (age == 19) {
			System.out.println("'이벤트 대상입니다'");
		} 
		else {
			System.out.println("'이벤트 대상이 아닙니다'");
		}

		sc.close();
	}
}
