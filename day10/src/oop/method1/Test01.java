package oop.method1;

public class Test01 {

	public static void main(String[] args) {
		//생성
		Player p1= new Player();
		Player p2= new Player();
		Player p3= new Player();
		Player p4= new Player();
		
		//초기화
		
		p1.setup(1,"킬리안 음바페","프랑스",8);
		p2.setup(2,"리오넬 메시","아르헨티나",7);
		p3.setup(3,"올리비에 지루","프랑스",4);
		p4.setup(4,"홀리안 알바레스","아르헨티나",4);
		
	
		//출력
		p1.show();//p1을 주인공으로 해서 show에 있는 코드를 실행하라

		p2.show();
		
		p3.show();
		
		p4.show();

	
		
		
		
	}

}
