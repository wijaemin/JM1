package oop.inherit7;

public class IPhone extends Phone{
	public IPhone(String number, String color) {
		super(number, color);
	}

	public void siri() {
		System.out.println("시리 기능 실행");
	}
}
