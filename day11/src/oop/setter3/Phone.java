package oop.setter3;

public class Phone {
	String name; //휴대폰 이름
	String company; //통신사
	int price; // 판매가
	int period; //약정개월

	void setName(String name) {
		this.name =name;
	}
	void setCompany(String company) {
		switch(company) {
		case "SK" :
		case "KT" :
		case "LG" :
		this.company =company;
		}
	}
	void setPrice(int price) {
		if(price>0) {
			this.price=price;
		}
	}
	void setPeriod(int period) {
		switch(period) {
		case 0:
		case 24:
		case 36:
			this.period=period;
		}
	}
	
	void setup(String name, String company,int price) {
		this.setup(name, company, price, 0);
	}

	void setup(String name,String company, int price, int period) {
		this.setName(name);
		this.setCompany(company);
		this.setPrice(price);
		this.setPeriod(period);
	}
	 
	
	
	void show() {
		System.out.println("<휴대폰 판매 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("통신사 : " + this.company);
		if(this.period==0) { //약정이 없다면
			int discount=this.price * 5/100;
			int result = this.price - discount;
			System.out.print("판매가: " +result + "원");
			System.out.println("(원가" + this.price + "원)");
		}
		else { //약정이 있다면
			int monthPrice =this.price /this.period;
			System.out.print("판매가 : " + this.price + "원");
			System.out.println("(월 " + monthPrice + "원)");
			
		}
	
		if(this.period ==0) {
			System.out.println("약정 없음");
		}
		else {
			
			System.out.println("약정기간 : " + this.period + "개월");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
