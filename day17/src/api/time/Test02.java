package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		//2023년 7월 11일
		//오후 1시 1분
		//13:01:05
		//2023-07-11 화 13:01:05
		
		//시간 객체
		Date a=new Date();
		
		//형식 객체
		SimpleDateFormat fmt1= new SimpleDateFormat("y년M월d일");
		String d1=fmt1.format(a);
		System.out.println(d1);
		
		SimpleDateFormat fmt2= new SimpleDateFormat("a h시 m분");
		String d2=fmt2.format(a);
		System.out.println(d2);
		
		SimpleDateFormat fmt3= new SimpleDateFormat("H:mm:ss");
		String d3=fmt3.format(a);
		System.out.println(d3);
		
		SimpleDateFormat fmt4= new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		String d4=fmt4.format(a);
		System.out.println(d4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
