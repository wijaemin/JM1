package day03;

public class Test15 {
	public static void main(String[] args) {
		
	//KH여행사는 다음과 같이 프로모션을 진행중입니다.
	//국내 어디든 한 사람당 1박에 10만원!
	// 추가로 25% 할인까지 챙겨가세요!
	//성인 3명이 7일동안 여행갈 때 예상 경비를 구하세요
	int count = 3;
	int day= 7;
	int rate = 25;
	int dayPrice=100000;
	
	
	int night=day-1;
	int price =dayPrice *night;
	int pay = count*price;
	int discount = pay*rate/100;
	int totalPay=pay-discount;
	
	System.out.println(pay);
	System.out.println(totalPay);
	
	
	
		
		
		
		
		
	}
}
