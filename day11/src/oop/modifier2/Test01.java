package oop.modifier2;

public class Test01 {
	public static void main(String[] args) {
		Account a= new Account("유재석",3,1000000,15,15000000);
		Account b= new Account("강호동",2,500000,5,2500000);
		Account c= new Account("신동엽",2,800000,2,10000000);
		
		
		a.show();
		b.show();
		c.show();
	}
}
