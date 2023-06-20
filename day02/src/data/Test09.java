package data;

public class Test09 {
	public static void main(String[] args) {
		//한 달에 200만원 씩 30년을 모으면 얼마인지 계산하여 출력
		/*int monthGetMoney = 2000000;
		int year =30;
		
		int yearGetMoney=2000000*12;
		int totalMoney =yearGetMoney*year;
		
		System.out.println(totalMoney);
		*/
		long money =2000000L;
		int year =30;
		
		int month = year *12;
		long total = (money) * month;
		
		System.out.println(total);
	}
}
