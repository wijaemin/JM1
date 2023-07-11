package api.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test10 {
	public static void main(String[] args) {
		//사용자에게 시작시간과 종료시간을 각각'HH:mm'형식으로 입력받아
		//총 이용시간과 이용요금을 출력하세요
		
		//이용요금은 한 시간당 1000원으로 계산하여 출력하세요
		//'''
		//LocalTime클래스는 Duration이라는 클래스와 관련이 있습니다
		//'''
		
		LocalTime start =LocalTime.parse("12:22");
		
		LocalTime end=LocalTime.parse("17:21");
		
		int price =1000;
		
	//	System.out.println(start.getHour());
		int totalMin=(end.getHour()-start.getHour())*60+end.getMinute()-start.getMinute();
		System.out.println(totalMin);
		int totalHour=totalMin/60;
		System.out.println("총 이용시간: " +totalHour +"시간 " + totalMin%60 + "분");
		
		//(시간 비용+ 분 비용)
		float totalPrice=(float)totalMin/60*price +totalMin%60*price/60; //이용 요금
		System.out.println(totalPrice);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
