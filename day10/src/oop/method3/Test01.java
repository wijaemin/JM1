package oop.method3;

public class Test01 {

	public static void main(String[] args) {
		//객체 생성
		Tariff t1= new Tariff();
		Tariff t2= new Tariff();
		Tariff t3= new Tariff();
		
		
		//데이터 초기화
		
		t1.setup("SK", "5G언텍트52", 52000, 200, 1000, 2000);
		t2.setup("KT", "5G세이브", 45000, 100, 900, 1500);
		t3.setup("LG", "5G시그니처", 130000, 500, 2000, 2500);
		
		//데이터 출력
		
		t1.show();
		System.out.println("\n");
		t2.show();
		System.out.println("\n");
		t3.show();
		
	}

}
