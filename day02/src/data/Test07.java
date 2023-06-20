package data;

public class Test07 {
	//영화관 금액 계산 문제
	public static void main(String[] args) {
		
		//입력
		int adultPrice = 1200;
		int teenPrice = 1000;
		int childPrice = 500;
		int adultCount =2;
		int teenCount =0;
		int childCount =1;
		//계산
		int adultTotal=adultPrice*adultCount;
		int teenTotal=teenPrice*teenCount;
		int childTotal=childPrice*childCount;
		int total= adultTotal +childTotal+teenTotal;
		//출력
		System.out.println(adultTotal);
		System.out.println(teenTotal);
		System.out.println(childTotal);
		System.out.println(total);
		
	}

}
