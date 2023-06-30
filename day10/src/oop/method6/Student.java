package oop.method6;

public class Student {

	int grade;
	int group;
	String name;
	int korean;
	int english;
	int math;
	int total;
	float everage;
	
	void setup(int grade,int group,String name,int korean, int english, int math) {
		this.setup(grade, group, name, korean, english, math, 0, 0);
	}
	
	void setup(int grade,int group,String name,int korean, int english, int math,int total,float everage) {
		this.grade=grade;
		this.group=group;
		this.name=name;
		this.korean=korean;
		this.english=english;
		this.math=math;
		this.total=korean+english+math;
		this.everage=(float)(korean+english+math)/3;
	}
	void show() {
		System.out.println("학년 = " + this.grade);
		System.out.println("반 = " + this.group);
		System.out.println("이름 = " + this.name);
		System.out.println("국어 = " + this.korean);
		System.out.println("영어 = " + this.english);
		System.out.println("수학 = " +this.math);
		System.out.println("총점= " +this.total);
		System.out.println("평균= " +this.everage);
		if(this.korean>=40&&this.english>=40&&this.math>=40&&this.everage>=60) {
			System.out.println("통과");
		}
		else {
			System.out.println("재평가");
		}
		
	}
	
}
