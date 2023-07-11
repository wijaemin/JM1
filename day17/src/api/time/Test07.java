package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		//사용자에게 연도와 월을 입력받아서 해당하는 달 달력의 시작 날짜를 출력
		//'''
		//2023년7월의 달력 시작 날짜는 6/25(일)입니다
		//'''
		Scanner sc= new Scanner(System.in);

		//System.out.print("연도를 입력하세요 : ");
		int year=2023;
		//System.out.print("월을 입력하세요 : ");
		int month =6;
		//계산
		//=달력은 일요일부터 출력한다
		//=1일이 무슨요일이냐에 따라서 전달의 출력 일수가 달라진다
		//=1일이 일요일(week=1)이면 전달 출력 일수는 0일
		//=1일이 월요일(week=2)이면 전달 출력 일수는 1일
		//=1일이 화요일(week=3)이면 전달 출력 일수는 2일
		//=1일이 수요일(week=4)이면 전달 출력 일수는 3일
		//=1일이 목요일(week=5)이면 전달 출력 일수는 4일
		//=1일이 금요일(week=6)이면 전달 출력 일수는 5일
		//=1일이 토요일(week=7)이면 전달 출력 일수는 6일
		Calendar c= Calendar.getInstance();
		c.set(year,month-1,1);
		int week=c.get(Calendar.DAY_OF_WEEK);
		System.out.println("week=" + week);
	//	c.add(Calendar.DATE, -(week-1));
	//	Date d= c.getTime();
	//	SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd E");
	//	System.out.println(fmt.format(d));
		//System.out.println("달력에는 전달을 "+(week-1)+"일 출력해야 합니다");
		
	}
}
