package oop.method4;

public class Test01 {

	public static void main(String[] args) {
		Menu m1=new Menu();
		Menu m2=new Menu();
		Menu m3=new Menu();
		Menu m4=new Menu();
		
		m1.setup("아메리카노", "음료", 2500,"행사중");
		m2.setup("모카라떼", "음료", 3500,"-");
		m3.setup("치즈케이크", "디저트", 5000,"행사중");
		m4.setup("마카롱", "디저트", 3000,"-");
		
		m1.show();
		System.out.println("\n");
		m2.show();
		System.out.println("\n");
		m3.show();
		System.out.println("\n");
		m4.show();
		
		
		
	}

}
