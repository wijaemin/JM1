package condition2;

import java.util.Scanner;

public class Test03_1 {

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
		System.out.print("정류장 수를 입력하세요 : ");
		int station =sc.nextInt();
		int fare;
		int card= 500;
		
		
		int over = station/5*100;
		if(age>=65 || age<8) {
			fare=card;
		}
		else if(age>=20) {
			fare=1250+card;
		}
		else if(age>=14) {
			fare=720+card;
		}
		else {
			fare=450+card;
		}
		int result =fare+over;
		System.out.println("요금은 " + result + "원 입니다.");
		sc.close();
	}

}
