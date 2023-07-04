package oop.keyword3;



//문제점
//[1]내부 구조가 복잡하
//[2] 객체를 꼭 만드렁야지
public class Calculator {
	//static 키워드가 붙은 메소드는 객체 생성 없이도 호출 가능(메모리 고정)
	public static int plus(int left,int right) {
	return left + right;
	}
}