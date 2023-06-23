package condition2;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		/* 어르신 65세 이상 무료
		 * 성인 20세 65세 미만 1250원
		 * 청소년 14세 이상 20세 미만 720원
		 * 어린이 8세 이상 14세 미만 450원
		 * 영유아 8세 미만 무료
		 * 사용자에게 나이를 입력받아 지하철 요금을 출력하세요
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		int fare;
		
		if(age>=65) {
			fare=0;
		}
		else if(20<=age && age<65) {
			fare=1250;
		}
		else if(14<=age && age<20) {
			fare=720;
		}
		else if(8<=age && age<14) {
			fare=450;
		}
		else {
			fare=0;
		}
		if (fare==0) {
			System.out.println("무료입니다.");
		}
		else  {
			System.out.println("요금은 " + fare + "원 입니다.");
		}
		
		sc.close();
	}

}
