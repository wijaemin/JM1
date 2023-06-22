package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test03_1 {

	public static void main(String[] args) {
		/* KH국밥집에는 65세 이상 어르신들만 30%할인된 가격에 국밥을 판매합니다.
		 * 
		 * 국밥 한 그릇에 7500원일 때, 출생년도 4자리와 그릇 수를 입력받아
		 * 상황에 맞는 결제 금액을 계산하여 출력하세요
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		LocalDate now =LocalDate.now();
		
		int rice =7500;
		System.out.print("출생년도(ex:1970년 = 1970)를 입력해주세요 = ");
		int birth =sc.nextInt();
		int year =now.getYear();
		System.out.print("그릇 수를 입력해주세요 = ");
		int count =sc.nextInt();
		int rate =30;
		
		
		int total =rice * count;
		int discount;
		
		int age = year-birth+1;
		
		if (age>=65) {
			discount = rice * rate/100;
		
		}
		else {
			discount= 0;
			
		}
		int result= total-discount;
		
		System.out.println("나이 : "+ age + "세");
		System.out.println("금액 : "+ result + "원");
		
		sc.close();
	}
}
