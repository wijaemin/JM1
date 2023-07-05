package oop.inherit6;

public class Phone {
	protected String number;
	protected String color;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Phone(String number,String color) {
		this.setNumber(number);
		this.setColor(color);
	}
	public final void show() {
		System.out.println("<휴대폰 정보>");
		System.out.println("전화번호 : " +this.getNumber() + ", 색상 : " + this.getColor());
	}
	//공통 메소드
	public void call() {
		System.out.println("전화 기능 실행");
	}
	public void sms() {
		System.out.println("문자 기능 실행");
	}
	
	
}
