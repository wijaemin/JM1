package oop.keyword7;

import java.util.Calendar;

public class Test06 {
	public static void main(String[] args) {
		//실제 자바 라이브러리에서 상수를 사용하는 코드
		int year=Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("year= " + year);
		
		int day=Calendar.getInstance().get(Calendar.DATE);
		System.out.println("day= "+ day);
		
		int month = Calendar.getInstance().get(Calendar.MONTH);
		System.out.println("month= "+ month);
	}
}
