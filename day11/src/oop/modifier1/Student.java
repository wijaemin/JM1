package oop.modifier1;

public class Student {
	//필드는 접근을 차단해야 한다(private)
	//- 같은 클래스 내부에서는 접근이 가능해야한다
	private String name;
	private int score;
	
	
	//필드를 제외한 나머지는 공개(public)을 붙인다
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score<0 ||score>100)
		return;
		this.score = score;
	}
	
	public Student() {
	}
	public Student(String name ,int score) {
		this.setName(name);
		this.setScore(score);
	}
}
