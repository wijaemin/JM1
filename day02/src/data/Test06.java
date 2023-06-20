package data;

public class Test06 {

	public static void main(String[] args) {
		int adultPrice = 15000;
		int teenPrice = 12000;
		int childPrice = 5000;
		int adultCount =2;
		int teenCount =2;
		int childCount=0;
		int adultTotal=adultPrice*adultCount;
		int teenTotal=teenPrice*teenCount;
		int childTotal=childPrice*childCount;
		int total= adultTotal +teenTotal+childTotal;
		
		
		System.out.println(adultTotal);
		System.out.println(teenTotal);
		System.out.println(childTotal);		
		System.out.println(total);
		
	}

}
