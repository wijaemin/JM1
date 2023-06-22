package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test03 {

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
		
		
		int price =rice * count;
		int discount = price * rate/100;
		int total=price-discount;
		
		int age = year-birth+1;
		
		if (age>=65) {
			
			System.out.println("나이는 " + age+ "세 입니다.");
			System.out.println("결제금액은 " + price + "원 입니다.");
			System.out.println("할인금액은 " + discount + "원 입니다.");
			System.out.println("최종금액은 할인된 가격으로 " + total + "원 입니다.");
		}
		else {
			System.out.println("나이는 " + age+ "세 입니다.");
			System.out.println("결제금액은 " + price + "원 입니다.");
		}
		
		sc.close();
	}
}
