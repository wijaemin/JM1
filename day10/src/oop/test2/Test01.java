package oop.test2;

public class Test01 {

	public static void main(String[] args) {
		
		PocketMonster p1= new PocketMonster();
		PocketMonster p2= new PocketMonster();
		PocketMonster p3= new PocketMonster();
		PocketMonster p4= new PocketMonster();
		
		
		
		p1.no=1;
		p1.name="이상해씨";
		p1.type ="풀";
		
		p2.no=4;
		p2.name="파이리";
		p2.type ="불꽃";
		
		p3.no=7;
		p3.name="꼬부기";
		p3.type ="물";
		
		p4.no=25;
		p4.name="피카츄";
		p4.type ="전기";
		
		
		System.out.println("번호 = " + p1.no);
		System.out.println("이름 = " + p1.name);
		System.out.println("속성 = " + p1.type);
		
		System.out.println("번호 = " + p2.no);
		System.out.println("이름 = " + p2.name);
		System.out.println("속성 = " + p2.type);
		
		System.out.println("번호 = " + p3.no);
		System.out.println("이름 = " + p3.name);
		System.out.println("속성 = " + p3.type);
		
		System.out.println("번호 = " + p4.no);
		System.out.println("이름 = " + p4.name);
		System.out.println("속성 = " + p4.type);
	}

}
