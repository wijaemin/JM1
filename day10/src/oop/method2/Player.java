package oop.method2;
//클래스
public class Player {
	//멤버 필드(member field) - 데이터
	String name;
	String event;
	String season;
	int gold;
	int silver;
	int bronze;
	//멤버 메소드(member method) -코드
	void setup(String name,String event,String season, int gold, int silver, int bronze) {
		this.name=name;
		this.event=event;
		this.season=season;
		this.gold=gold;
		this.silver=silver;
		this.bronze=bronze;
		}
	//출력
	void show() {
		
		System.out.println("<메달리스트 정보>");
		System.out.println("선수 이름 : " + this.name);
		System.out.println("종목 : " + this.event);
		System.out.println("구분 : " + this.season);
		System.out.println("금메달 : " + this.gold);
		System.out.println("은메달 : " + this.silver);
		System.out.println("동메달 : " + this.bronze);
	}
	
	
}
