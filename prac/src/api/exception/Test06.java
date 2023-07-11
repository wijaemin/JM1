package api.exception;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//입력
		try {
		
		Scanner sc =new Scanner(System.in);
		System.out.print("출생년월 입력 : ");
		String input = sc.next();
		
		int currentYear=2023;
		int currentMonth=7;
		//계산
		String[] part=input.split("-");//-를 구분자(delimiter)로 하여 분해
		int year=Integer.parseInt(part[0]);
		int month=Integer.parseInt(part[1]);
		if(year>currentYear||(year==currentYear&&month>currentMonth)) {
			throw new Exception("미래의 시간은 입력할 수 없습니다.");
		}
		if(year<1900) {
			throw new Exception("1900년 미만은 입력할 수 없습니다.");
		}
		if(month<0&&month>12) {
			throw new Exception("출생월이 잘못되었습니다.");
		}
		
		//한국나이 계산
		int koreanAge=2023-year+1;
		//만나이 계산=개월수 /12
		int totalMonth=(currentYear-year)*12+(currentMonth-month);
		//System.out.println("개월 수 =" + totalMonth);
		int globalAge=totalMonth/12;
		
		//출력
		System.out.println("한국나이 : " + koreanAge + "살");
		System.out.println("만나이 : " +globalAge + "살");
			}
		catch(Exception e) {
			if(e.getMessage()==null) {
				System.err.println("프로그램 오류발생");
			}
			else {
				System.err.println(e.getMessage());
			}
		}
	
	}
}
