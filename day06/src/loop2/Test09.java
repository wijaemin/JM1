package loop2;

import java.util.Scanner;

public class Test09 {
	public static void main(String[]args) {
		/*사용자에게 숫자를 10개 입력받아서 다음을 계산
		 * 1.홀수의 개수
		 * 2.짝수의 개수
		 * 3.전체 합계
		 * 4.전체 평균
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		int even=0;
		int odd=0;
		double total =0;
		int count =0;
		double average=0;
		for(int i =0 ; i<10;i++) {
			System.out.print("숫자를 입력하세요 : ");
			int num=sc.nextInt();
			if(num%2==1) {
				odd++;
			}
			else {
				even++;
			}
			total+=num;
			count++;
		}
		average=total/count;
		System.out.println("홀수의 개수는 " + odd + "개");
		System.out.println("짝수의 개수는 " + even + "개");
		System.out.println("전체 합계 : " + total);
		System.out.println("전체 평균 : " + average);
		
		sc.close();
	}
}
