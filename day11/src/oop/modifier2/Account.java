package oop.modifier2;
//적금계좌 클래스
public class Account {
	//멤버 필드
	 String name; // 예금주명
	private int year; // 총 기간
	private int count; // 진행된 입금회차
	private int pay; // 1회 입금액
	private int balance; // 잔액
	
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getYear() {
		return year;
	}
	void setYear(int year) {
		switch(year) {
		case 1:
		case 2:
		case 3:
		case 5: 
		case 10:
			this.year = year;
		}
	}
	int getCount() {
		return count;
	}
	void setCount(int count) {
		if(count<1) return;
		if(count>this.getTotalCount()) return;
		this.count = count;
	}
	int getPay() {
		return pay;
	}
	void setPay(int pay) {
		if(pay<=0)return;
		this.pay = pay;
	}
	int getBalance() {
		return balance;
	}
	void setBalance(int balance) {
		if(balance <=0) return;
		this.balance = balance;
	}
	
	public int getMonth() {
		return this.year *12;
	}
	public int getTotalCount() {
		return this.getMonth()+1;
		
	}
	//만기인지 아닌지 판정하는 메소드
	public boolean isFinish() {
		if(this.getTotalCount()==this.getCount()) {
			return true;
		}
		else {
			return false;
		}
		//return this.getTotalCount()==this.getCount();
	}
	
	public int getRemainCount() {
		return this.getTotalCount()-this.count;
	}
	
	public int getFuture() {
		return this.balance + this.getRemainCount()*this.pay;
	}
	
	
	
	
	public void show() {
		System.out.println("<계좌정보>");
		System.out.println("예금주 : " + this.name);
		System.out.println("예치기간 : " + this.year +"년 (" + this.getMonth() + "개월)");
		System.out.println("월부금 : " + this.pay/10000 + "만원");
		System.out.println("납입회차 : (" + this.count + "/" + this.getTotalCount() + ")");
		System.out.println("계좌잔액 : " + this.balance/10000 + "만원");

		if(this.isFinish()) {
				System.out.println("해당 적금은 만기되었습니다.");
		}
		System.out.println("* 만기 예상금액 : " + this.getFuture()/10000+"만원 *");
		}

	
	
	
	//생성자
	
	public Account(String name,int year,int pay) {
		this(name, year, pay, 1, 0);
	}
	
	public Account(String name,int year,int pay,int count, int balance) {
		this.setName(name);
		this.setYear(year);
		this.setPay(pay);
		this.setCount(count);
		this.setBalance(balance);
		
	}
	
	
}
