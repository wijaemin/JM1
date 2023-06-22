package day03;

public class Test14 {
	public static void main(String[]args) {
		//할인금액 구하기
		//300만원짜리 컴퓨터를 20% 할인하면 얼마인가?
		
		
		//입력
		int price = 3000000;
		int rate =20;
		//계산
		int discount = price * rate/100;
		//System.out.println(discount);
		int pay =price-discount;
		//출력
		System.out.println(pay);
		
		
		
		
		
		
	}
}
