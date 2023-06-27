package random;

import java.util.Random;
import java.util.Scanner;

public class Test05_1 {

	public static void main(String[] args) {
		/* 사용자에게 랜덤으로 2단부터 9단 사이의 구구단 문제를 10개 출제합니다.
		 * 
		 * 사용자가 입력한 값으로 정답/오답을 판정하고
		 * 모든 문제 출제가 끝나면 정답과 오답 개수를 출력해주세요
		 * 
		 * 
		 */
		Random r =new Random();
		Scanner sc =new Scanner(System.in);
		
		int countO=0;
		int countX=0;
		
		for(int i=0;i<10;i++) {
			int dan=r.nextInt(8)+2;
			int times=r.nextInt(9)+1;
			
			System.out.print(dan + " X " + times + " = " );
			int result=sc.nextInt();
				
			if(dan*times == result) {
				System.out.println("정답!");
				countO++;
			}
			else {
				System.out.println("오답..");
				countX++;
				if(countX ==3) {
					System.out.println("오답이 3회라 구구단을 종료합니다.");
					break;
				}
			}
		}
		sc.close();
		System.out.println("정답 개수 : " + countO);
		System.out.println("오답 개수 : " + countX);
	}
}
