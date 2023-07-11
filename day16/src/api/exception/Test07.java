package api.exception;

public class Test07 {
	public static void main(String [] args) {
		System.out.println(DateCalculator.getMonthDay(2023,2));
		System.out.println(DateCalculator.getYearday(2023, 7, 11));
		
		//만약에 2021-03-15일생이면
		int total =0;
		total += 365-DateCalculator.getYearday(2021, 3, 15)+1; //전체에서 자기 자신까지 뺏으니깐 나중에 자기 자신은 추가(+1)
		total +=365; //2022년
		total +=DateCalculator.getYearday(2023, 7, 11);//2023-01-01부터2023-07-11까지
		System.out.println("total : " + total);
	}
}
