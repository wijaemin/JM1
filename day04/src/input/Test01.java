package input;

import java.io.IOException;

public class Test01 {

	public static void main(String[] args) throws IOException {
		//표준 입력
		//-System.in 을 사용하여 처리
		//- 사용자가 입력해주기를 기다려야한다
		
		int a =System.in.read();
		System.out.println("a= "+ a);
		int b =System.in.read();
		System.out.println("b= "+ b);
		int c =System.in.read();
		System.out.println("c="+ c);
		int d =System.in.read();
		System.out.println("d= "+ d);
		//hi 입력하면 a=h , b는 =105 , c는 \r , d는 \n
		
	}

}
