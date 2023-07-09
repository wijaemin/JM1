package parctice3;

public class Phone {
	String name;
	String company;
	int price;
	int period;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		switch(company) {
		case "SK" :
		case "KT" :
		case "LG" :
		}
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price<0) return;
		this.price = price;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		switch(period) {
		case 0:
		case 24:
		case 36:
		}
		this.period = period;
	}
	void setup(String name,String company,int price) {
		this.setup(name, company, price, 0);
	}
	void setup(String name,String company,int price, int period) {
		this.setName(name);
		this.setCompany(company);
		this.setPrice(price);
		this.setPeriod(period);
	}
	void show() {
		System.out.println("<휴대폰 판매 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("통신사 : " + this.getCompany());
		if(period==0) {
			int discount=this.getPrice()*5/100;
			int total=this.getPrice()-discount;
			System.out.println("할인가격 : " + total + "원(약정없음)" );
			System.out.println("원가 : " + this.getPrice() + "원");
		}
		else {
			int monthPrice=this.getPrice()/this.getPeriod();
			System.out.println("가격 : " + this.getPrice() + "원");
			System.out.println("월 할부금 : " + monthPrice + "원");
			
		}
		
		
	}
	
}
