package oop.method4;

public class Menu {
	String name;
	String group;
	int price;
	String event;
	
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
