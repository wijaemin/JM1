package input;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		/* KH분식점의 메뉴판은 다음과 같습니다.
		 * 이름 		가격
		 * 떡볶이		3000원
		 * 튀김		500원
		 * 순대		2000원
		 * 사용자에게 떡볶이, 튀김, 순대 개수를 입력받아 결재금액을 출력
		 * (단, 현재 행사 중이라서 10% 할인된 가격으로 판매함)
		 * 
		 * 
		 */
		Scanner sc =new Scanner(System.in);
		System.out.print("\t메뉴판\n메뉴\t\t가격\n떡볶이 \t3000원\n튀김\t\t  500원\n순대\t\t2000원\n" );
		
		
		System.out.print("떡볶이 개수 : ");
		int dduk =sc.nextInt();
		System.out.print("튀김 개수 : ");
		int fried = sc.nextInt();
		System.out.print("순대 개수 : ");
		int sundae = sc.nextInt();
		
		int ddukPrice =3000;
		int friedPrice = 500;
		int sundaePrice = 2000;
		int rate =10;
		
		//결재 금액
		int ddukTotal= ddukPrice * dduk;
		int friedTotal= friedPrice * fried;
		int sundaeTotal= sundaePrice * sundae;
		int price = ddukTotal+friedTotal+sundaeTotal; 
		int discount = price * rate/100;
		int total = price - discount;
		
		System.out.println("<결제정보>");
		
		System.out.println("결제 금액은 " +	price + "원 입니다.");
		System.out.println("할인 금액은 " + discount + "원 입니다.");
		System.out.println("최종 금액은 " + total + "원 입니다.");
	}

}
