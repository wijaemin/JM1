package oop.keyword7;

import java.util.Random;



public class Test02 {
	public static void main(String[]args) {
		//상수의(constant) 필요성?
		//(Ex)가위바위보 출력
		
		//약속 - 가위(0), 바위(1), 보(2)'
		
		final int scissors = 0;
		final int rock = 1;
		final int paper = 2;
		
		Random r= new Random();

		int choice =r.nextInt(3);
		
		switch(choice) {
		case scissors:
			System.out.println("가위");
			break;
		case rock:
			System.out.println("바위");
			break;
		case paper:
			System.out.println("보");
			break;
		}
	}
}
