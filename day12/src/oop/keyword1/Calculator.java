package oop.keyword1;
//클래스 구성요소(필드 메소드 생성자)
public class Calculator {
	//필드 
	private int left;
	private int right;
	
	//메소드
	//setter+getter 생략
	
	public int getTotal() {
		return this.left + this.right;
		
	}
	//생성자
	public Calculator(int left,int right) {
		this.left=left;
		this.right=right;
		
	}
	
}
