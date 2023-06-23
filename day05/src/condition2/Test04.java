package condition2;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		/*KH여행사에서 세 번째 프로모션을 진행합니다.
		 * 무조건 1인당 1박 10만원을 유지한 채
		 * 계절별로 다음과 같이 할인하도록 할 예정입니다.
		 * 
		 *계절		월		할인율
		 * 봄		3,4,5		20%
		 * 여름	6,7,8		10%
		 * 가을 	9,10,11	30%
		 * 겨울	12,1,2		5%
		 */
		Scanner sc = new Scanner(System.in);
		
		int cost=100000;
		System.out.print("몇박을 하는지 입력하세요 : ");
		int day = sc.nextInt();
		System.out.print("인구 수를 입력하세요 : ");
		int people = sc.nextInt();
		System.out.print("달을 입력하세요 : ");
		int month =sc.nextInt();
		
		int rate;
		int price =cost * day * people;
		

		if(month==3||month==4||month==5) {
			rate=20;
		}
		else if(month==6||month==7||month==8) {
			rate=10;
		}
		else if(month==9||month==10||month==11) {
			rate=30;
		}
		else {
			rate=5;
		}
		int discount= price*rate/100;
		int total =price -discount;
		System.out.println("예상경비는 " + price + "원 입니다.");
		System.out.println("할인율은 " + rate + "% 입니다.");
		System.out.println("할인 값은 " + discount + "원 입니다.");
		System.out.println("최종경비는  " + total + "원 입니다.");
		
		sc.close();
	}

}
