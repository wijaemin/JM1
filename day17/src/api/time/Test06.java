package api.time;

import java.util.Calendar;

public class Test06 {
	public static void main(String[] args) {
		//오늘부터 100일동안 다이어트를 한다고 했을 때
		//다이어트가 끝나는 날을 구하여 출력
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		
	//	System.out.println(year);
	//	System.out.println(month);
	//	System.out.println(day);
		
		int finish=day+100;
		c.set(year,month,finish);
		
		System.out.println(c.get(Calendar.YEAR) +"년");
		System.out.println(c.get(Calendar.MONTH)+"월");
		System.out.println(c.get(Calendar.DAY_OF_MONTH)+"일");
		
		
	}
}
