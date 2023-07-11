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
		Date d= new Date();
		
		SimpleDateFormat fmt1= new SimpleDateFormat("y년 M월 d일");
		System.out.println(fmt1.format(d));
		SimpleDateFormat fmt2= new SimpleDateFormat("a h시 m분");
		System.out.println(fmt2.format(d));
		SimpleDateFormat fmt3 =new SimpleDateFormat("H:mm:ss");
		System.out.println(fmt3.format(d));
		SimpleDateFormat fmt4 =new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(fmt4.format(d));
		
		
	}
}
