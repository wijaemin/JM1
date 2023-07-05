package oop.inherit5;

public class GalaxyFold4 extends Galaxy{
	
	//+@
	public void show() {
		System.out.println("<휴대폰 정보>");
		//System.out.println("번호 : " + this.number);
		//System.out.println("번호 : " + super.number); //부모클래스의 번호
		System.out.println("번호 : "+ number); //this로 처리함
	}
	//매소드 재정의(method override)
	//- 상속받은 메소드를 똑같이 한 번 더 만들어서 내가 만든게 실행되도록 하는
	//-뭔가 상속받은 메소드가 마음에 안들 때 사용
	@Override//어노테이션(Annotaton) - 역할을 부여(해시태그)
	public void call() {
		System.out.println("갤럭시 폴드4의 통화기능 실행!");
	}
	
	//public void battery() {
		
	//생성자
	//-생성할 때 반드시 넣어야 하는 값을 지정하는 구문
	//-부모 클래스는 생성할 일이 없는데?
	//-자식 클래스 객체가 생성되면 자동으로 부모 클래스의 내용이 내부에 생성
	//- 반드시 초기화되어야 하는 필드에 대한 생성자가 있을수 있다.
	//-(중요)부모클래스의 생성자를 만족시키는 생성자가 자식 클래스에 있어야한다
	
	
	//부모클래스에 생성자가 있다면 자식클래스에 생성자가 있어야한다
	//- 부모 클래스가 필요로 하는 값을 전달해야한다
	public GalaxyFold4(String color) {
		super(color);
	}
}
