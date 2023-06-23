package loop;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i =0;i<5;i++) {
			System.out.print("숫자를 입력하세요 : ");
			int num =sc.nextInt();
		}
		sc.close();
	}
	
}
