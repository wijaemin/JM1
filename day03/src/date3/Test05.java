package date3;

public class Test05 {
	/*건강 검진은 30세 이상인 사람들을 대상으로 2년에 한 번씩 진행합니다.
	 * 
	 * 올해가 짝수 해라면, 짝수년도 출생자가 대상이고
	 * 올해가 홀수 해라면, 홀수년도 출생자가 대상입니다.
	 * 
	 * 어떤 사람의 출생년도(ex:1985)를 입력값으로 두고 이사람이 올해 건강검진 대상인지 아닌지 판정하여 출력
	 */
	
	
	
		public static void main(String[] args) {
		
		int birth = 1985;
		int year =2023;
		
		int age =year-birth+1;
		boolean target = (year-birth)%2==0 && age>=30;
		
		System.out.println(age);
		System.out.println(target);
		
		/*
		int birth = 1986;
		int year =2023;
		
		int age = year-birth+1;
		boolean condition1 =age>=30;
		boolean condition2 = birth%2 ==0 && year%2 ==0;
		boolean condition3 = birth%2 !=0 && year%2 !=0;
		boolean condition4 = condition2 || condition3;
		boolean target = condition1 && condition4 ;
		System.out.println(age);
		System.out.println(target);
		*/
		
		
		
		//boolean target = age>=30 &&  boolean condition1 =(boolean condition2= year%2==0&&birth%2;)||(boolean condition3 =year%2==1&& birth%2==1;)
			
			
			
	
	
		
	}
}
