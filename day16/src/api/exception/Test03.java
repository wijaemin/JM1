package api.exception;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		try {
			
			Scanner sc= new Scanner(System.in);
			System.out.print("생년월일(YYYY-MM-DD)을 입력하세요 : ");
			String birth =sc.next();
			
			String year=birth.substring(0, 4);
			//System.out.println(year);
			String month=birth.substring(5,7);
			//System.out.println(month);
			String day=birth.substring(8,10);
			//System.out.println(day);
			
			int yyyy=Integer.parseInt(year);
			int mm=Integer.parseInt(month);
			int dd=Integer.parseInt(day);
			
			System.out.println("출생년도 : " + yyyy + "년");
			System.out.println("출생월 : " + mm + "월");
			System.out.println("출생일 : " + dd + "일");
		}
		catch(Exception e) {
			System.err.println("입력 형식에 맞게 입력해주세요.");
		}
		
		
		// java.lang.NumberFormatException
		
	}
}
