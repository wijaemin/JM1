package api.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test10_1 {
	public static void main(String[] args) {
		//사용자에게 시작시간과 종료시간을 각각'HH:mm'형식으로 입력받아
		//총 이용시간과 이용요금을 출력하세요
		
		//이용요금은 한 시간당 1000원으로 계산하여 출력하세요
		//'''
		//LocalTime클래스는 Duration이라는 클래스와 관련이 있습니다
		//'''
		
		//입력
		String begin="14:30";
		String end ="19:15";
		
		//계산
		LocalTime t1=LocalTime.parse(begin);
		LocalTime t2= LocalTime.parse(end);
		
		Duration duration =Duration.between(t1, t2);
		System.out.println(duration);
		long seconds =duration.getSeconds();
		System.out.println("seconds = " +seconds);
		
		long totalM=seconds/60;
		long hour=seconds/60/60;
		long minute=seconds/60%60;
		//요금계산
		int pricePerHour =1000;
		float pricePerMinute=1000/60f;
		float totalPrice=pricePerMinute*totalM;
		
		
		//출력
		System.out.println("이용시간: " +hour +"시간 " +minute + "분"); 
		System.out.println("이용요금 : " +(int)totalPrice);
		System.out.println("이용요금 : " +(int)Math.floor(totalPrice) + "원");
		System.out.println("이용요금 : " +Math.round(totalPrice) + "원");
		System.out.println("이용요금 : " +(int)Math.ceil(totalPrice) + "원");
		
		
		
		
		
		
		
		
		
	}
}
