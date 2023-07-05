package oop.inherit5;
//갤럭시 시리즈의 상위 클래스
public class Galaxy {
	//공통 필드 
	//- 접근 제한을 주의
	//- private을 사용한다면 이 클래스에서 정한 방식으로만 이용이 가능!
	//- protected를 사용한다면 자식 클래스(패키지) 만큼은 자유롭게 접근이 가능!

	protected String color;
	protected String number;
	protected int pirce;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPirce() {
		return pirce;
	}
	public void setPirce(int pirce) {
		this.pirce = pirce;
	}
	//공통 메소드
	//- 메소드는 재정의(override)될 수 있다
	//- 기본적으로 재정의는 허용된다
	//- final 키워드를 붙이면 재정의 할 수 없다
	
	public void call() {
		System.out.println("전화가능");
	}
	public final void battery() {
		System.out.println("배터리 표시 가능");
	}
	//생성자
		//-생성할 때 반드시 넣어야 하는 값을 지정하는 구문
		//-부모 클래스는 생성할 일이 없는데?
		//-자식 클래스 객체가 생성되면 자동으로 부모 클래스의 내용이 내부에 생성
		//- 반드시 초기화되어야 하는 필드에 대한 생성자가 있을수 있다.
		//-(중요)부모클래스의 생성자를 만족시키는 생성자가 자식 클래스에 있어야한다
	public Galaxy(String color) {
		this.setColor(color);
	}
}
