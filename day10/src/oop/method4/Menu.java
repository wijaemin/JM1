package oop.method4;

public class Menu {
	String name;
	String group;
	int price;
	String event;
	
	//setup을 두 종류로 구현(메소드 오버로딩,method overloading
	//[1]3개의 데이터가 들어오면 이벤트는 안하는 걸로 생각하여 처리
	//[2]4개의 데이터가 들어오면 이벤트 정보도 설정하는걸로 처리
	void setup(String name,String group, int price) {
		this.name=name;
		this.group=group;
		this.price=price;
	}
	
	void setup(String name,String group, int price, String event) {
		this.name=name;
		this.group=group;
		this.price=price;
		this.event=event;
	}
	void show() {
		if(this.event=="행사중"){
			System.out.println("이름: " + this.name + "(행사중)");
		}
		else {
			System.out.println("이름: " + this.name);
		}
		System.out.println("분류: " + this.group);
		if(this.event=="행사중"){
			System.out.println("할인가 : " + this.price *80/100 + "원");
		}
		else {
			System.out.println("판매가 : " + this.price + "원");
		}
	}
	
	
	
	
}
