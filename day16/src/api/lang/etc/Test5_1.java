package api.lang.etc;

public class Test5_1 {
	public static void main(String[] args) {
		//Integer 클래스
		//=Wrapper 클래스 =(총8종류)
		//= int와 관련된 여러 기능들을 제공하는 클래스
		//= int를 객체 형태로 사용하도록 만들어주는 클래스
		
		//생성 - Java 9 이후부터 비추천 처리
		Long a= new Long(10);
		Long b= new Long("10");
		System.out.println(a.toString());//System.out.println(a);
		System.out.println(b.toString());//System.out.println(b);
		//자주쓰는 값(-128~+127)은 신규로 만들지 않고 캐싱된 값을 사용
		Long c=Long.valueOf(10);
		Long d= Long.valueOf("10");
		System.out.println("c= " + c);
		System.out.println("d= " + d);
		
		//int와 Integer는 무슨 차이가 있는가?
		//- 10+20을 각각의 방식으로 계산
		//- 123을 2진수로 변환하여 출력
		long v1=10L,v2=20L;
		long v3=v1+v2;
		System.out.println("v3 = "+ v3);
		Long w1=Long.valueOf(10);
		Long w2=Long.valueOf(20);
		Long w3=Long.sum(w1, w2);
		System.out.println("w3= " + w3.toString());
		
		//====================================
		
		StringBuffer buffer =new StringBuffer();
		
		long x= 123L;
		for(long i =x;i>0;i/=2) {
			System.out.println("i=" + i + ", 나머지= " + i %2);
			buffer.insert(0, i%2);
		}
		System.out.println("x = " + buffer.toString());
		
		Long y=Long.valueOf(123);
		System.out.println("y = " + Long.toBinaryString(y));
		
		//int와 Integer는 호환이 된다
		
		Long z= 10+20L; //int(원시형)-------> Integer(참조형):auto-boxing
		
		System.out.println(z);
		long p=z; //Integer(참조형) ----------->int(원시형) : auto-inboxing
		
		//int와 Integer의 결정적인 차이
		//=null(참조 대상이 없음)
		//int q1=null;//error
		Long q2=null;//ok
		
		System.out.println(q2);
		
	}
}
