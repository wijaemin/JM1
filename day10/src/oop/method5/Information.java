package oop.method5;

public class Information {
	String name;
	String type;
	int price;
	boolean deliver;
	boolean event;
	
	void setup(String name,String type,int price) {
		this.setup(name, type, price, false, false);
		
	}

	void setup(String name,String type,int price,boolean deliver,boolean event) {
		this.name=name;
		this.type=type;
		this.price=price;
		this.deliver=deliver;
		this.event=event;
		
	}
	void show() {
	
		System.out.println("상품명 : " + this.name);
		
		System.out.println("상품분류 : " + this.type);
		if(event) {
			System.out.println("판매가 : " + this.price*90/100 +"원"+"\"행사중\"");
		}
		else {
			System.out.println("판매가 : " + this.price + "원");
		}
		if(deliver) {
			System.out.println("새벽배송 가능 (+2500원)");
		}
		else {
			System.out.println("새벽배송 불가");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
