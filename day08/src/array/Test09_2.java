package array;

import java.util.Random;

public class Test09_2 {

	public static void main(String[] args) {
		/* 로또 시뮬레이션
		 * 
		 * 로또 번호 중에서 가장 많이 나오는 번호를 찾으려는 목적으로 랜덤을 이용하여
		 * 로또 번호를 1000번 정도 추첨하려고 합니다.
		 * 
		 * 1.각 번호(1~45)가 몇번 나왔는지 측정하여 출력하세요
		 * 2.가장 많이 나온 번호를 찾아서 출력하세요
		 * 
		 * 
		 */
		
		Random r = new Random();
	
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int count5=0;
		int count6=0;
		
		for(int i= 0;i<1000;i++) {//1부터 num.length(10)까지 반복
			int dice=r.nextInt(6)+1;//숫자 범위
			System.out.println(i+1 + "번째 주사위 = " + dice);
			if(dice==1) {
				count1++;
			}
			else if(dice==2) {
				count2++;
			}
			else if(dice==3) {
				count3++;
			}
			else if(dice==4) {
				count4++;
			}
			else if(dice==5) {
				count5++;
			}
			else {
				count6++;
			}
		}	
		System.out.println("========================");
		System.out.println("숫자 1의 개수 =" + count1);
		System.out.println("숫자 2의 개수 =" + count2);
		System.out.println("숫자 3의 개수 =" + count3);
		System.out.println("숫자 4의 개수 =" + count4);
		System.out.println("숫자 5의 개수 =" + count5);
		System.out.println("숫자 6의 개수 =" + count6);
	}

}
