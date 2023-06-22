package data;

public class Test08 {
	public static void main(String[] args) {
		//정수의 특징
		
		//[1] 정수는 소수점이 없는 수이다.
		// int a = 3.14; 소수점 X
		
		//[2] 정수는 크기에 따라 여러 종류로 나뉜다.
		// -	byte,short,int,long
		byte b =10;
		//[3] 크기를 벗어나면 저장이 안된다.
		//byte c = 150;
		int d = 1000000000;
		long e =1000000000L;//long은표시를 해야된다
		
		System.out.println(e);
		//[4] 정수는 순환형 구조를 가진다
		long f  =1234567*1234567L;
		int v1 = 10;
		int v2 = 3;
		System.out.println(v1/v2);//몫
		System.out.println(v1%v2);//나머지
		
		
		
		
		
		
		
		
		
		
	}
}
