package oop.constructor4;

public class Test01 {
	public static void main(String[] args) {
		Bankbook b1 =new Bankbook("유재석",3,38,1000000,15000000);
		Bankbook b2 =new Bankbook("강호동",2,5,1000000,2500000);
		Bankbook b3 =new Bankbook("신동엽",2,8,800000,10000000);
		
		b1.show();
		b2.show();
		b3.show();
	}
}
