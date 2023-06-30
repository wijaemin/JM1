package oop.method2;

public class Player {
	String name;
	String event;
	String season;
	int gold;
	int silver;
	int bronze;
	//초기화용
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
		System.out.println("선수 이름 : " + name);
		System.out.println("종목 : " + event);
		System.out.println("구분 : " + season);
		System.out.println("금메달 : " + gold);
		System.out.println("은메달 : " + silver);
		System.out.println("동메달 : " + bronze);
	}
	
	
}
