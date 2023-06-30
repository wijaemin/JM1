package oop.method6_1;

public class Student {
	int grade;
	int group;
	String name;
	int korean;
	int english;
	int math;
	
	void setup(int grade,int group,String name,int korean, int english, int math) {
		this.grade=grade;
		this.group=group;
		this.name=name;
		this.korean=korean;
		this.english=english;
		this.math=math;
	}
	//문제점 show에서 너무 많은 일을 하고 있다
	//해결책 계싼을 메소드가 할 수 있도록 추가 메소드 생성
	
	//[1]]총점을 구해주는 메소드
	//(참고) return 키워드는 "반환"과 "종료"의 의미를 가지는 키워드
	//(참고) void 키워드는 "결과물이 없음"이란 의미를가지는 키워드
	int getTotal() {
		return this.korean+this.english+this.math;
	}
	//[2] 평균을 구해주는 메소드
	float getAverage() {
		return this.getTotal()/3f;
	}
	//[3] 합격/불합격을 판정하는 메소드
	boolean getPass() {
		return this.korean>=40 && this.english>=40
				&& this.math >=40 &&this.getAverage()>=60;
	}
	
	
	
	void show() {
		System.out.println("학년 = " + this.grade);
		System.out.println("반 = " + this.group);
		System.out.println("이름 = " + this.name);
		System.out.println("국어 = " + this.korean);
		System.out.println("영어 = " + this.english);
		System.out.println("수학 = " +this.math);
		
		
		
		
		System.out.println("총점= " +this.getTotal());
		System.out.println("평균= " +this.getAverage());
		if(this.getPass()) {
			System.out.println("통과");
		}
		else {
			System.out.println("재평가");
		}
		
	}
	
}
