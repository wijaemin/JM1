package oop.method3;

public class Tariff {
	String company;
	String product;
	int price;
	int data;
	int call;
	int message;
	
	//초기화용
	void setup(String company,String product,int price,int data, int call, int message) {
		this.company=company;
		this.product=product;
		this.price=price;
		this.data=data;
		this.call=call;
		this.message=message;
	}
	//출력용
	
	void show() {
		System.out.println("통신사 : " + company);
		System.out.println("상품명 : " + product);
		System.out.println("월정액 : " + price);
		System.out.println("데이터(GB) : " + data);
		System.out.println("통화(분) : " + call);
		System.out.println("문자(건) : " + message);
	}
	
	
}
