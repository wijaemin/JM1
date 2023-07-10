package api.exception;

import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {
		try { //플랜 A
			
			//입력
			Scanner sc= new Scanner(System.in);
			System.out.print("생년월일(YYYY-MM-DD)을 입력하세요 : ");
			String input =sc.next();
			sc.close();
			//계산
			String part1=input.substring(0, 4);
			String part2=input.substring(5,7);
			String part3=input.substring(8,10);
			
			int year=Integer.parseInt(part1);
			int month=Integer.parseInt(part2);
			int day=Integer.parseInt(part3);
			
			System.out.println("출생년도 : " + year + "년");
			System.out.println("출생월 : " + month + "월");
			System.out.println("출생일 : " + day + "일");
			}
			
			
			
		catch(java.lang.StringIndexOutOfBoundsException e) {
		System.err.println("입력 형식에 맞게 입력해주세요.");
		}
		catch(java.lang.NumberFormatException e) {
			System.err.println("생년월일에 숫자를 입력해주세요.");
		}
		
		// java.lang.NumberFormatException
		
	}
}
