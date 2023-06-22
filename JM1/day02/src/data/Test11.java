package data;

public class Test11 {
	public static void main(String[] args) {
		
		// PC방에서 게임을 9시 40분에 시작해서 12시 25분까지 했습니다
		// 한 시간 당 1200원일 때 이용요금과 이용시간을 각각 출력하세요
		
		//입력
		int startPcHour = 9,startPcMin = 40;
		int finishPcHour = 12, finishPcMin = 25;
		//계산
		int startPcTime = startPcHour * 60 + startPcMin;
		int finishPcTime = finishPcHour * 60 + finishPcMin;
		
		int totalPcTime = finishPcTime -startPcTime;
		int totalHour =totalPcTime/60;
		int totalMin = totalPcTime%60;
		
		
		int hourMoney =1200;
		int minMoney =hourMoney/60;
		int totalHourMoney =totalHour*hourMoney;
		int totalMinMoney=totalMin*minMoney;
		int totalMoney =totalHourMoney +totalMinMoney;
		
		
		
		System.out.println(totalHour);
		System.out.println(totalMin);
		System.out.println(totalMoney);
		System.out.println("이용 요금은 " + totalMoney + "원입니다." );
		System.out.println("이용시간은 " + totalHour + "시간 " + totalMin + "분 입니다.");
		
	}
	
}
