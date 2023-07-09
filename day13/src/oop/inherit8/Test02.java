package oop.inherit8;

public class Test02 {
	public static void main(String[] args) {
		//객체를 업캐스팅하여 생성
		//상속 관계에서 특정 클래스로 대충 묶어서 표현하고 싶을 때
		//Warrior a = new Warrior("테스터1");
		//Magician a = new Magician("테스터1");
		Archer a = new Archer("테스터1");
		
		//Warrior b =new Warrior("테스터2");
		Magician b =new Magician("테스터2");
		//Archer b = new Archer("테스터2");
		Interaction.battle(a, b);
		
		
	}
}
