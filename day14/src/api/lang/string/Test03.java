package api.lang.string;

public class Test03 {
	public static void main(String[] args) {
		//문자열의 구조 /비교 원리
		//=자바에서 문자열은 불변(immutable)으로 관리된다
		//=문자열은 편차가 심하기 때문에 성능 향상을 위해 자바에서 선택한 방식
		//=new가 있는 경우는 신규로 생성하여 공유 되지 않는다
		//=비교 연산은 위험하다
		String a ="hello";
		String b= "hello";
		String c= new String("hello");
		String d= new String("hello");
		
		System.out.println(a==b);
		System.out.println(c==d);
		System.out.println(a.equals(b));
		
		System.out.println(c.equals(d));
		
	}
}
