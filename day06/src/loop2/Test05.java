package loop2;

import java.util.Scanner;


public class Test05 {
	public static void main(String[]args) {
		/*1. 사용자에게 원하는 단을 입력받으면 해당 단의 구구단을 출력
		 * 2.정답을 지우고 사용자에게 정답을 입력받아서 정답/오답 판정
		 * 3.정답과 오답의 개수를 세어 모든 문제 출제 후 출력
		 */
		Scanner sc= new Scanner(System.in);
		System.out.print("단 : ");
		int dan =sc.nextInt();

		int countO=0;
		int countX=0;
		int comboCount =0;
		System.out.println("<" + dan + "단>");
		/*for(int i=1;i<=9;i++) {
			System.out.println(dan + "X" + i + "=" + dan*i);
		}
		
		System.out.println();
		*/
		for(int i=1;i<=9;i++) {
			System.out.print(dan + "X" + i + "= ");
			int answer =sc.nextInt();
			if(answer == dan*i) {
				System.out.println("정답!");
				countO++;
				comboCount++;
				System.out.println("콤보카운트 : " + comboCount + "개");
			}
			else {
				System.out.println("오답!");
				countX++;
				comboCount=0;
			}
		}
		System.out.println("=======================");
		
		System.out.println("정답 : " + countO + "개");
		System.out.println("오답 : " + countX + "개");
		sc.close();
	}
}
