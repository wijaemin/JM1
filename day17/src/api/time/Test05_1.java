package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Test05_1 {
	public static void main(String[] args) {
		//올해 중에서 랜덤으로 하루를 추천하여 출력(오늘 제외)
		Random r=new Random();
		
		Calendar c= Calendar.getInstance();
		int result=r.nextInt(365)+1;
		c.set(2023,0,result);
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		
		
	}
}
