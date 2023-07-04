package oop.constructor4;

public class Bankbook {
	String name; // 이름
	int year; //기간
	int month; //회차
	int amount; //납입금액
	int money; //현재 금액
	
	void setName(String name) {
		this.name= name;
	}
	void setYear(int year) {
		switch(year) {
		case 1:
		case 2:
		case 3:
		case 5:
		case 10:
			this.year=year;
		}
	}
	void setMonth(int month) {
		if(month<0) {
		return;
		}
	
		this.month=month;
	}
	void setAmount(int amount) {
		if(amount%10000==0) {
			this.amount=amount;
		}
	}
	void setMoney(int money) {
		if(money<0)
		return;
		
		this.money=money;
	}

	
	String getName() {
		return this.name;
	}
	int getYear() {
		return this.year;
	}
	int getMonth() {
		return this.month;
	}
	int getAmount() {
		return this.amount;
	}
	int getMoney() {
		return this.money;
	}
	String getOver() {
	if(this.month>this.getTotalYear()) {
		return "적금이 만기입니다";
		}
	else {
	return "만기가 아닙니다";
		}
	}
	int getTotalMonth() {//년도당 만기 회차
		return this.year * 12;
	}
	int getTotalYear() {//총 만기 회차
		return this.getTotalMonth()+1;
	}
	int getRemainCount() {
		return this.getTotalYear()-this.getMonth();
	}
	int getFuture() { //예상 만기금액
		return this.money +this.getRemainCount()*this.getAmount();
	}
	
	
	Bankbook(String name,int year,int amount){
		this(name,year,1,amount,0);
	}
	
	
	Bankbook(String name,int year,int month,int amount,int money){
		this.setName(name);
		this.setYear(year);
		this.setMonth(month);
		this.setAmount(amount);
		this.setMoney(money);
	}
	
	void show() {
		System.out.println("KH 내집마련 적금통장 가입자 정보");
		System.out.println("이름 : " +this.getName());
		System.out.println("총납입기간 : " + this.getYear() + "년");
		System.out.println("현재납입회차 : " + this.getMonth() + "회차");
		System.out.println("월납입금액 : " +this.getAmount()/10000 + "만원");
		System.out.println("총 잔액 : " + this.getMoney()/10000 + "만원");
		System.out.println(this.getOver());
		System.out.println();
		System.out.println("예상 만기 금액 : " + this.getFuture()/10000 + "만원");
		System.out.println();
	}
	void next() {
		if(this.month>this.year*12+1) {
			return;
		}
		this.month++;
		this.money+=this.amount;
	}
	
}
	
