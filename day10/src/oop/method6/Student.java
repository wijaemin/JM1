package oop.method6;

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
	
	void show() {
		System.out.println("학년 = " + this.grade);
		System.out.println("반 = " + this.group);
		System.out.println("이름 = " + this.name);
		System.out.println("국어 = " + this.korean);
		System.out.println("영어 = " + this.english);
		System.out.println("수학 = " +this.math);
		int total=this.korean+this.english+this.math;
		System.out.println("총점= " +total);
		float everage=total/3f;
		System.out.println("평균= " +everage);
		boolean pass= this.korean>=40
							&&this.english>=40
							&&this.math>=40
							&&everage>=60;
		if(pass) {
			System.out.println("통과");
		}
		else {
			System.out.println("재평가");
		}
		
	}
	
}
