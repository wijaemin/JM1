package api.exception;

public class DateCalculator {
	
	//연+월을 월로 바꿔주는 메소드
	
	
	
	//월별 날짜를 반환하는 메소드
	public static int getMonthDay(int year,int month) {
		boolean leepYear=year%400==0 ||(year%4==0&&year%100!=0);
		switch(month) {
		case 2:
			if(leepYear) 	return 29;
			else return 28;
		case 4,6,9,11:
			return 30;
		default:
			return 31;
		}
		
	}
	//올해 며칠째인지 계산하는 메소드
	public static int getYearday(int year, int month , int day) {
		int total =0;
		for(int i=1;i<month;i++) {
			total+=getMonthDay(year,i);
		}
		total +=day;
		return total;
	}
	
	
	
	
	
	
	
	
	
}
