package oop.method2;

public class Test01 {

	public static void main(String[] args) {
		//객체 생성
		Player p1= new Player();
		Player p2= new Player();
		Player p3= new Player();
		
		p1.setup("진종오", "사격", "하계", 4, 2, 0);
		p2.setup("김수녕", "양궁", "하계", 4, 1, 1);
		p3.setup("전이경", "쇼트트렉", "동계", 4, 0, 1);
		
		p1.show();
		System.out.println();
		p2.show();
		System.out.println();
		p3.show();
		
		
		
		
		
		
	}

}
