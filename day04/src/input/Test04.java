package input;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		/* 강의장 입실시각과 퇴실시각을 입력받아
		 * 수업에 참여한 시간을 계산하여 출력
		 *
		 * 
		 * 입실시각 입력:0925
		 * /100=09
		 * %100=25
		 * 퇴실시각 입력:1830
		 * 
		 * 수업에 참여한 시간은 9시간 5분 입니다.
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		System.out.println("시간 입력 ex)05시30분 = 0530");
		System.out.print("입실시각 입력 : ");
		int enter=sc.nextInt();
		int enterHour= enter/100;
		int enterMin = enter%100;
		//System.out.println(enter);
		//System.out.println(enterHour);
		//System.out.println(enterMin);
		
		
		System.out.print("퇴실시각 입력 : ");
		int leave=sc.nextInt();
		int leaveHour=leave/100;
		int leaveMin = leave%100;
		//System.out.println(leave);
		//System.out.println(leaveHour);
		//System.out.println(leaveMin);
		
		int enterTime =enterHour * 60 +enterMin;
		int leaveTime =leaveHour * 60 +leaveMin;
		
		int time=leaveTime-enterTime;
		
		int hour = time/60;
		int min = time%60;
		
			
		System.out.println("수업에 참여한 시간은 " + hour + "시간 " + min + "분 입니다" );
		
		sc.close();
		
	}
}
