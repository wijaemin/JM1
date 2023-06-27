package random;

import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		/*	모두의마블이라는 게임에서는 다음과 같은 규칙이 있습니다
		 * 
		 * 주사위 두 개를 던집니다
		 * 주사위 두 개가 같은 값이 나오면 더블이라고 부르며 한 번 더 던질 수 있습니다.
		 *
		 *1. 100턴 동안 주사위를 던졌을 때 더블이 몇번 나오는지 카운트해서 출력
		 *2. 더블이 나올 확률을 구하여 출력
		 */
		Random r= new Random();
		
		int count=0;
		for(int i=1;i<=100;i++) {
			
		int dice1 =r.nextInt(6)+1;
		int dice2 =r.nextInt(6)+1;
		
		System.out.println("주사위 = " + dice1 + ", " + dice2);
		
			if(dice1==dice2) {
				System.out.println("더블!");
				count++;
			}
		}
		System.out.println("더블이 나온 횟수는 : " + count);
		System.out.println("더블이 나올 확률은 : "+ count%100 + "%");
		
		
		
		
		
		
		
		
	}

}
