package oop.getter2;

public class Test01 {
	public static void main(String[] args) {
		Student s1= new Student();
		Student s2= new Student();
		Student s3= new Student();
		
		s1.setup("마리오", 1, 90, 80, 70);
		s2.setup("루이지", 1, 85, 85, 83);
		s3.setup("쿠파", 3, 70, 60, 55);
		
		
		s1.show();
		s2.show();
		s3.show();
		
	}
}
