package data;

public class Test06 {

	public static void main(String[] args) {
		int adult = 15000;
		int youth = 12000;
		int child = 5000;
		int adultCount =2;
		int youthCount =2;
		int childCount=0;
		int adultTotal=adult*adultCount;
		int youthTotal=youth*youthCount;
		int childTotal=child*childCount;
		int total= adultTotal +youthTotal+childTotal;
		
		
		System.out.println(adultTotal);
		System.out.println(youthTotal);
		System.out.println(total);
		
	}

}
