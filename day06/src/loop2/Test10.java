package loop2;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		/* 사용자에게 이번주 월요일부터 금요일까지 공부한 시간을 입력받습니다.
		 * 입력된 정보를 토대로 다음을 계산하여 출력
		 * 
		 * 1.총 공부한 시간
		 * 2.일 평균 공부한 시간
		 * 
		 * 입력은 시간과 분을 따로 받으며, 출력도 시간과 분을 따로 받습니다.
		 * 
		 */
		int time=0;
		int count =0;
		int average;
		Scanner sc= new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			System.out.print("시간을 입력하세요 : ");
			int hour =sc.nextInt();
			System.out.print("분을 입력하세요 : ");
			int min = sc.nextInt();
			time+= hour*60+min;	
			count++;
		}
		int hourT=time/60;
		int minT=time%60;
		average= time/count;
		int averageH=average/60;
		int averageM=average%60;

		
		System.out.println("총 공부한 시간은 "+ hourT + "시간 " + minT + "분");
		
		System.out.println("일 평균 공부시간은 약 "+ averageH + "시간 " + averageM + "분");

		sc.close();
	}
}
