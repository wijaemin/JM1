package loop3;

import java.util.Random;

public class Test05_1 {
	public static void main(String[] args) {
		/*모바일 게임에서 이벤트 패키지를 1500원에 판매합니다
		 * 이벤트 패키지에서는 1~9개의 쿠폰이 나오며 이 쿠폰을 이용하여 각종 아이템을
		 * 구매할 수 있습니다.
		 * 
		 * 게임사에서 공개한 쿠폰 획득 확률은 다음과 같습니다
		 * 개수	확률
		 * 1개		7.69% 
		 * 2개		9.62%		17.31
		 * 3개		11.54%	28.85
		 * 4개		13.46%	42.31
		 * 5개		15.38%	57.69
		 * 6개		13.46%	71.15
		 * 7개		11.54%	82.69
		 * 8개		9.62%		92.31
		 * 9개		7.69%		100
		 * 
		 * 최고급 보상이 쿠폰999개에 판매되고 있을 때 최고급 보상을 획득하기 위해 결제해야
		 * 할 금액을 시뮬레이션으로 구하시오.
		 */
		Random r = new Random();
		int count=0;
		int total=0;
		int price = 1500;
		
		while(true) {
			float event = r.nextFloat(100)+1;
			//System.out.println(event);
			total++;
			if(event<=7.69) {
			count+=1;
			System.out.println("1개 획득!");
			}
			else if(event<=17.31) {
			count+=2;
			System.out.println("2개 획득!");
			}
			else if(event<28.85) {
			count+=3;
			System.out.println("3개 획득!");
			}
			else if(event<42.31) {
			count+=4;
			System.out.println("4개 획득!");
			}
			else if(event<57.69) {
			count+=5;
			System.out.println("5개 획득!");
			}
			else if(event<71.15) {
			count+=6;
			System.out.println("6개 획득!");
			}
			else if(event<82.69) {
			count+=7;
			System.out.println("7개 획득!");
			}
			else if(event<92.31) {
			count+=8;
			System.out.println("8개 획득!");
			}
			else {
			count+=9;
			System.out.println("9개 획득!");
			}
			System.out.println("현재 개수 = " + count + "개");
			if(count>=999) {
				System.out.println("999개 이상을 모았습니다!");
				break;
			}
		}
		System.out.println("구매한 횟수 = " + total);
		int totalPrice=total*price;
		System.out.println(totalPrice);
		
	}
}
