package date3;

public class Test07 {

	public static void main(String[] args) {
	/*	실제 =365.24..일, 달력 = 365일
	 * 윤년에는 2월 29일까지 있다(366일)
	 * 4의 배수인 해는 윤년으로 간주
	 * 100의 배수인 해는 4의 배수여도 윤년이 아닌걸로 간주
	 * 400의 배수인 해는 100의 배우여도 윤년으로 간주
	 */
		int year=1900;
		boolean is4= year%4 ==0;
		boolean isNot100=year%100!=0;
		boolean is400=year%400==0;
		//leap =윤년
		//boolean leap =fourY&&(fHundY||hundY);
		boolean leap = is400||(is4&&isNot100);
		
		System.out.println(leap);
	}

}
