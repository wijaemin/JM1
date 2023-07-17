package api.file.object;

import java.io.File;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("KH은행에 오신 것을 환영합니다.");
		File target =new File("sameple/bank.kh");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		Account account=new Account(name);
		System.out.println(name +" 님 환영합니다");
		
		System.out.print("입력(1-정보출력/2-입금/3-출금/0-종료) : ");
		int num=sc.nextInt();
		if(num==1) {
			account.show();
		}
		else if(num==2) {
			System.out.print("입금할 금액 입력");
			int plus=sc.nextInt();
		}
		else if(num==3) {
			System.out.print("출금할 금액 입력");
			int minus=sc.nextInt();
		}
		
	}
}
