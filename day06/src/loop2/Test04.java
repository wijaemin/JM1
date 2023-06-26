package loop2;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		/* 소수는 나누기가 어려운 숫자들을 말합니다
		 * 나누기가 어렵다는 것은 1이나 자기자신 빼고 나누어 떨어지는 수가 없나는 뜻
		 * 소수가 아니라는것은 1과 자기자신을 제외하고도 나누어 떨어지는 수가 있다는 뜻
		 * 
		 * 
		 */
		Scanner sc= new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		//입력
		int num=sc.nextInt();
		int count=0;
		
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				count++;
			}
		}
		if(count==2) {
			System.out.println(num + "은 소수입니다.");
		}
		else {
			System.out.println(num + "은 소수가 아닙니다.");
		}

		sc.close();
	}
}
