package oop.inherit4;

public class Mp4 extends File {
	private int  speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void Forward() {
		System.out.println("빨리감기 기능 실행");
	}
	public void Rewind() {
		System.out.println("되감기 기능 실행");
	}
	
	
}
