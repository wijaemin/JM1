package api.exception;

public class Test08 {
	public static void main(String [] args) {
		System.out.println(DateCalculator.getMonthDay(2023,2));
		System.out.println(DateCalculator.getYearday(2023, 7, 11));
		
		//만약에 2021-03-15일생이면
		int total =0;
		total += 365-DateCalculator.getYearday(2021, 3, 15)+1;
		total +=365;
		total +=DateCalculator.getYearday(2023, 7, 11);
		System.out.println("total : " + total);
	}
}
