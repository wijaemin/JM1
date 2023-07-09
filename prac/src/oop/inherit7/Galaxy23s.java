package oop.inherit7;

public class Galaxy23s extends Galaxy{
	public Galaxy23s(String number, String color) {
		super(number, color);
	}
	//마음에 안드는 기능을 재정의(override);
		@Override
		public void call() {
			System.out.println("갤럭시 23s 전화 기능 실행");
		}
		@Override
		public void sms() {
			System.out.println("갤럭시 23s 문자 기능 실행");
		}
		@Override
		public void samsungPay() {
			System.out.println("갤럭시 23s 삼성페이 기능 실행");
		}
	public void bixby() {
		System.out.println("Galaxy23s 빅스비 기능 실행");
	}
}
