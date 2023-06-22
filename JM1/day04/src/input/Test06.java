package input;

//자동 import는 컨트롤+쉬프트+O로 합니다

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//문자열 입력
		Scanner sc= new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.println("입력한 이름 : " + name);
		
		sc.close();
	}
}
