package oop.inherit4;

public class Mp3 extends File {
	private int duration;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public void forward() {
		System.out.println("빨리감기 기능 실행");
	}
	public void rewind() {
		System.out.println("되감기 기능 실행");
	}
	
	
	
	
}
