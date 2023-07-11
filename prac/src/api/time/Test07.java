package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07 {
	public static void main(String[] args) {
		int year = 2023;
		int month = 10;
		
		Calendar c =Calendar.getInstance();
		c.set(year, month-1,1);
		int week=c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		c.add(Calendar.DATE, -(week-1));
		
		int count=0;
		for(int i=0;i<42;i++) {
			Date d= c.getTime();//c의 시간 값을 Date d에 넣기
			SimpleDateFormat fmt= new SimpleDateFormat("d");//일만 출력
			System.out.print(fmt.format(d));//일 출력
			System.out.print("\t"); //띄어쓰기
			c.add(Calendar.DATE,1); //다음 날을 위해 +1
			count++; //카운트 1추가
			if(count%7==0) { //카운트를 7로 나눴을때 0이면
				System.out.println(); //줄 바꾸기
			}
		}
	}
}
