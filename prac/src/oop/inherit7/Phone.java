package oop.inherit7;

public class Phone {
	private String number;
	private String color;
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
	
	public void show() {
		System.out.println("전화번호 : " + this.getNumber() + ", 색상 : " + this.getColor() );
	}
	public void call() {
		System.out.println("전화기능 실행");
	}
	public void sms() {
		System.out.println("문자 기능 실행");
	}
}
