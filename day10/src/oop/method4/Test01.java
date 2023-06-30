package oop.method4;

public class Test01 {

	public static void main(String[] args) {
		Menu m1=new Menu();
		Menu m2=new Menu();
		Menu m3=new Menu();
		Menu m4=new Menu();
		
		//이벤트의 경우는 설정하지 않으면 안하는 걸로 할 수 있겠는가?
		//=setup의 처리 방식을 2가지로 분리할 수 있는가?
		
		m1.setup("아메리카노", "음료", 2500,"행사중");
		m2.setup("모카라떼", "음료", 3500);
		m3.setup("치즈케이크", "디저트", 5000,"행사중");
		m4.setup("마카롱", "디저트", 3000);
		
		m1.show();
		System.out.println("\n");
		m2.show();
		System.out.println("\n");
		m3.show();
		System.out.println("\n");
		m4.show();
		
		
		
	}

}
