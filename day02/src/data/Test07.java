package data;

public class Test07 {

	public static void main(String[] args) {
		int adult = 1200;
		int youth = 1000;
		int child = 500;
		int adultCount =2;
		int youthCount =0;
		int childCount =1;
		int adultTotal=adult*adultCount;
		int youthTotal=youth*youthCount;
		int childTotal=child*childCount;
		int total= adultTotal +childTotal+youthTotal;
		
		
		System.out.println(adultTotal);
		System.out.println(childTotal);
		System.out.println(total);
		
	}

}
