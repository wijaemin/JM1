package oop.setter2;

public class Academy {
	String name;
	int hour;
	int price;
	String type;

	void setup(String name,int hour, int price,String type) {
		this.name=name;
		this.setHour(hour);
		this.setPrice(price);
		this.setType(type);
	}
	void setHour(int hour) {
		if(hour>0 && hour%30==0) {//0과-30도 30의 배수 이기 때문에 0보다 크게 라는 조건을 추가 해주는게 좋다
			this.hour=hour;
		}
	}
	//void setPrice(int price) {
	//	if(price>0) {
	//		this.price=price;
	//	}
	//}
	void setPrice(int price) {
		if(price<0) {
			return;
		}
		this.price=price;
		
	}
		
	
	void setType(String type) {
		switch(type) {
		case "온라인" :
		case "오프라인" :
		case "혼합" :
		this.type=type;
		}
	}
	
	void show() {
		System.out.println("<강좌 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("시간 : " + this.hour);
		System.out.println("가격 : " + this.price);
		System.out.println("유형 : " + this.type);
	}
	
	
	
	
	
	
	
	
	
	
	
}
