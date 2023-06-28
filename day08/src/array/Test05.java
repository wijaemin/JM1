package array;

import java.util.Scanner;

public class Test05 {
	public static void main(String[]args) {
		/* 배열과 반복문
		 * ex:3개의 숫자를 입력받아서 출력, 합계 구하기
		 * 배열에 크기가 정해지면 자동으로 length 라는 버튼이 생긴다
		 */
		int[] data = new int[3];
		//data ======>[0] [0] [0]
		
		Scanner sc= new Scanner(System.in);
		
		for(int i =0;i<data.length;i++) {
		data[i] =sc.nextInt();
		}
		sc.close();
		for(int i=0 ; i<data.length ;i++) {			
			System.out.println(data[i]);
		}
	
		
		
	}
	
}
