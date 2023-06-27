package loop3;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		/* 숫자 모래성 땅따먹기
		 *  
		 *  최초에 100이라는 값을 정해두고
		 *  사용자에게 한 자리 숫자(1~9)를 입력받아 차감을 합니다.
		 *  
		 *  차감을 하다가 0 이하가 되면 반복을 종료하고 게임 오버 메세지를 출력
		 *  
		 *  몇 번 만에 게임오버가 되었는지 측정하여 출력
		 *  
		 */
		Scanner sc= new Scanner(System.in);
		int first =100;
		int count = 0;
		while(true) {
		System.out.print("1에서 9까지의 숫자를 입력하세요 : ");
		int me =sc.nextInt();
		if (me<1||me>9) {
			System.out.println("다시입력하세요!");
			continue;	
		}
		
		count++;
		first -=me;
		System.out.println(first);
		if(first<=0) {
			System.out.println("게임오버!");
			break;
			}
		}
		System.out.println("총 " + count + "번 입력");
		
		sc.close();
		
	}
}
