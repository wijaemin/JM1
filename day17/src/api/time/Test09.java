package api.time;

import java.time.LocalDate;
import java.util.Scanner;

public class Test09 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		
		
		String input=sc.next();
		
		LocalDate d=LocalDate.parse(input);
		System.out.println(d);
		
		LocalDate after100 =d.plusDays(100L);
		System.out.println(after100.getYear()+"년 " +after100.getMonthValue() +"월 " + after100.getDayOfMonth()+ "일");
		System.out.println("100일 : " +after100);
		
		LocalDate after200 =d.plusDays(200L);
		System.out.println(after200.getYear()+"/" +after200.getMonthValue() +"/" + after200.getDayOfMonth());
		System.out.println("200일 : " +after200);
		
		LocalDate after300 =d.plusDays(300L);
		System.out.println("300일 : " +after300);
		
		LocalDate after1Y=d.plusYears(1L);
		System.out.println("1주년 : " +after1Y);
		
		LocalDate after2Y=d.plusYears(2L);
		System.out.println("2주년 : " +after2Y);
		
		LocalDate after10Y=d.plusYears(10L);
		System.out.println("10주년 : " +after10Y);
		
		
		
	}
}
