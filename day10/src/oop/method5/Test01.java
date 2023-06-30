package oop.method5;

public class Test01 {

	public static void main(String[] args) {
		Information i1= new Information();
		Information i2= new Information();
		Information i3= new Information();
		Information i4= new Information();
		
		
		
		i1.setup("참이슬후레쉬","주류", 1200,true,true);
		i2.setup("클라우드맥주","주류", 3000,false,true);
		i3.setup("바나나킥","과자", 1500,false,true);
		i4.setup("허니버터침","거ㅣ지", 2000,true,false);
		
		i1.show();
		System.out.println("\n");
		i2.show();
		System.out.println("\n");
		i3.show();
		System.out.println("\n");
		i4.show();
		
		
		
		
		
		
		
		
		
		
	}

}
