package data;

public class Test10 {

	public static void main(String[] args) {
		//어제 2시간 45분, 오늘 1시간 50분 공부했습니다.
		//총 공부한 시간을 구하여 출력
		//규칙:시간은 가장 작은 단위로 변환하여 푼다
		/*
		int yesterdayHour=2;
		int yesterdayMinute=45;
		int todayHour= 1;
		int todayMinute =50;
		
		int minuteChangeToHour=(yesterdayMinute+todayMinute)/60;
		int totalMinute=(yesterdayMinute+todayMinute)%60;
		int totalHour=yesterdayHour+todayHour+minuteChangeToHour;
		
		System.out.println(totalHour);
		System.out.println(totalMinute);
		System.out.println(totalHour + "시간 " + totalMinute + "분");
		*/
		int yesterdayHour = 2;
		int yesterdayMin = 45;
		int todayHour= 1;
		int todayMin = 50;
		
		int yesterdayTime =yesterdayHour * 60 +yesterdayMin;
		int todayTime =todayHour * 60 + todayMin;
		
		int time =yesterdayTime + todayTime;
				
		int hour = time/60;
		int min = time%60;
		
		System.out.println(hour);
		System.out.println(min);
		
		

	}
}
