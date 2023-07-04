package oop.total1;

public class Time {
	private long value;
	
	//setter,getter 메소드
	public void setValue(long value) {
		if(value<0L)return;
		this.value=value;
	}
	
	public long getValue() {
		return value;
	}
	//생성자
	
	public Time(long hour,long minute,long second) {
		long total=hour*60*60+minute*60+second;
		this.setValue(total);
	}
	public Time(long minute,long second) {
		long total =minute*60+second;
		this.setValue(total);
	}
	public Time(long second) {
		this.setValue(second);
	}
	
	//가상의 getter 메소드
	
	public long getHour() {
		return this.value/60/60;
	}
	public long getMinute() {
		return this.value/60%60;
	}
	public long getSecond() {
		return this.value%60;
	}
	
	public void show(){
		System.out.print(this.getHour());
		System.out.print("시간");
		System.out.print(this.getMinute());
		System.out.print("분");
		System.out.print(this.getSecond());
		System.out.println("초");
	}
	
}

