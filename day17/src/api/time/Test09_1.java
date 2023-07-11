package api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test09_1 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		
		
		String input=sc.next();
		
		//LocalDate d=LocalDate.parse(input,해석기준);
		DateTimeFormatter fmt =DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate d =LocalDate.parse(input,fmt);
		System.out.println(d);
		
		long[] days=new long[] {
				100L,200L,300L,365L,
				400L,500L,600L,700L,
				365*2L,800L,900L,365L*3,
				365L*4,365L*5
		};
		DateTimeFormatter fmt2 =DateTimeFormatter.ofPattern("y년M월d일");
		for(int i=0;i<days.length;i++) {
			LocalDate future=d.plusDays(days[i]);
			System.out.println(days[i]+"일 뒤 = " +future.format(fmt2));
		}
		
//		LocalDate after100 =d.plusDays(100L);
//		LocalDate after200 =d.plusDays(200L);
//		LocalDate after300 =d.plusDays(300L);
//		LocalDate after1Y=d.plusYears(1L);
//		LocalDate after2Y=d.plusYears(2L);
//		LocalDate after10Y=d.plusYears(10L);
//		
//		System.out.println("100일 : " +after100);
//		System.out.println("200일 : " +after200);
//		System.out.println("300일 : " +after300);
//		System.out.println("1주년 : " +after1Y);
//		System.out.println("2주년 : " +after2Y);
//		System.out.println("10주년 : " +after10Y);
		
		
		
		
		
		
		
	}
}
