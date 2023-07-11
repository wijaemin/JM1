package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test7_1 {
	public static void main(String[] args) {
		//사용자에게 연도와 월을 입력받아서 해당하는 달 달력의 시작 날짜를 출력
		//'''
		//2023년7월의 달력 시작 날짜는 6/25(일)입니다
		//'''
		Scanner sc= new Scanner(System.in);

		//System.out.print("연도를 입력하세요 : ");
		int year=2022;
		//System.out.print("월을 입력하세요 : ");
		int month =7;
		//계산
		Calendar c= Calendar.getInstance();
		c.set(year,month-1,1);
		int week=c.get(Calendar.DAY_OF_WEEK);
	//	System.out.println("week=" + week);
		c.add(Calendar.DATE, -(week-1));
		
		
		
		int count=0;
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0; i<42;i++) {
			Date d= c.getTime();
			SimpleDateFormat fmt= new SimpleDateFormat("d");
			System.out.print(fmt.format(d));
			System.out.print("\t");
			c.add(Calendar.DATE, 1);
			count++;
			if(count %7==0) {
				System.out.println();
			}
		}
	}
}
