package array;

import java.util.Random;

public class Test14 {

	public static void main(String[] args) {
		/*
		 * 1.모든 자리는 1번씩 다른 위치와 바뀌어야 한다
		 * 2.어디랑 섞일지 대상 위치는 모르며 같은 위치일 수도 있다
		 * 3.랜덤으로 정해진 위치와 현재 위치의 데이터를 바꾸도록 구현
		 * 
		 */
		Random r= new Random();
		int[]num=new int[] {1,2,3,4,5};
		
		for(int i=0;i<num.length;i++) {
		int random=r.nextInt(5);//0,1,2,3,4
		int backup=num[i];
		num[i]=num[random];
		num[random]=backup;
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
		System.out.println("=================");
		}
	/*	System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
		System.out.println(num[4]);
	*/
	}

}
