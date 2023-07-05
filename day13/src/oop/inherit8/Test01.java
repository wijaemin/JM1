package oop.inherit8;

public class Test01 {
	public static void main(String[] args) {
		
		//플레이어는 생성 불가(추상클래스라서)
		//Player p =new Player("포테이토");
		Warrior p1= new Warrior("위재민");
		p1.showInfo();
		p1.attack();
		p1.move();
		p1.shop();
		Magician p2=new Magician("위재우");
		p2.showInfo();
		p2.attack();
		p2.move();
		p2.shop();
		Archer p3 = new Archer("서호진");
		p3.showInfo();
		p3.attack();
		p3.move();
		p3.shop();
	}
}
