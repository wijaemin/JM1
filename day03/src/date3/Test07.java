package date3;

public class Test07 {

	public static void main(String[] args) {
	/*	실제 =365.24..일, 달력 = 365일
	 * 윤년에는 2월 29일까지 있다(366일)
	 * 4의 배수인 해는 윤년으로 간주
	 * 100의 배수인 해는 4의 배수여도 윤년이 아닌걸로 간주
	 * 400의 배수인 해는 100의 배우여도 윤년으로 간주
	 */
		int year=2100;
		//4의 배수인 해 year%4==0
		//100의 배수인 해 year%100 ==0
		//400의 배수인 해 year%400==0
		//true일때 윤년인걸로
		boolean fourY= year%4 ==0;
		boolean hundY=year%100==0;
		boolean fHundY=year%400==0;
		//leap =윤년
		boolean leap =(fHundY&&(fourY&&hundY))||((fHundY||hundY)||fourY);
		System.out.println(leap);
		/*400=1이면 무조건 1
		100= 400이 0이고 100이 1이면 0
				4= 400이 1이면 무조건 1, 400이 0이고 100이 1이면 0,
					400이랑 100이 0이고 4가 1이면 1
					
					
					
					
					
					
		*/
			
				
		
		
		
		
	}

}
