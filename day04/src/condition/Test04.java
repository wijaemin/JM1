package condition;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		/* KH여행사에서 두 번째 프로모션을 다음과 같이 진행하려고 합니다
		 * 
		 * 여름 매출이 저조하여 여름에 여행 갈 경우 비용에서 25%를 할인합니다
		 * 여름이 아닌 다른 계절은 할인 행사를 진행하지 않습니다
		 * 
		 * 전과 동일하게 '국내 어디든 1인 1박에 10만원' 이라는 슬로건을 유지할 때
		 * 사용자에게 필요한 정보를 입력받아 예상 경비를 출력하도로 구현하세요
		 * 
		 * 
		 */
		Scanner sc =new Scanner(System.in);
		System.out.print("여행을 가는 달(ex: 8월 = 8)을 입력해주세요. = ");
		int month = sc.nextInt();
		System.out.print("여행을 몇일(ex:5일 = 5)을 가는지 입력해주세요. = ");
		int day =sc.nextInt();
		System.out.print("몇명(ex:5명 = 5)이서 가는지 입력해주세요. = ");
		int people =sc.nextInt();
		int price = 100000;
		int rate = 25;
		int discount;
		
		int money =day*price*people;
		
		
		if (6<=month && month<=8 ) {
			discount= money*rate/100;
		}
		else {
			discount=0;
		}
		int total=money-discount;
		
		System.out.println("총 비용은 " + total + "입니다.");

		sc.close();
	}
}
