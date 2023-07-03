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
		if(hour%30==0) {
			this.hour=hour;
		}
	}
	void setPrice(int price) {
		if(price>0) {
			this.price=price;
		}
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
		System.out.println(this.name);
		System.out.println(this.hour);
		System.out.println(this.price);
		System.out.println(this.type);
	}
	
	
	
	
	
	
	
	
	
	
	
}
