package oop.method6_1;

public class Test01 {
 //[1]값 설정을 할 때 어떻게 비정상적인 값을 차단할 것인가?
 //[2] 객체를 생성하면서 동시에 값을 설정할 수는 없는가?
	public static void main(String[] args) {
		Student s1=new Student();
		Student s2=new Student();
		Student s3=new Student();
		Student s4=new Student();
		
		
		s1.setup(1, 1,"마리오", 50, 60, 50);
		s2.setup(1, 1,"루이지", 60, 90, 50);
		s3.setup(1, 2,"쿠파", 70, 70, 80);
		s4.setup(1, 2,"요시", 80, 85, 35);
		
		s1.show();
		System.out.println("\n");
		s2.show();
		System.out.println("\n");
		s3.show();
		System.out.println("\n");
		s4.show();
		
	}

}
