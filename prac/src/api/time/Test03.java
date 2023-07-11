package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
		Calendar c =Calendar.getInstance();
		System.out.println(c);
		
		Date d =c.getTime();
		System.out.println(d);
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(fmt.format(d));
	}
}
