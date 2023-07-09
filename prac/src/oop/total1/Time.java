package oop.total1;

public class Time {
	
	long value;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		if(value<0) return;
		this.value = value;
	}
	
	public Time(long hour, long min, long sec) {
		long total=hour * 60 * 60 + min *60 + sec;
		this.setValue(total);
	}
	public Time(long min, long sec) {
		long total=min *60 + sec;
		this.setValue(total);
	}
	public Time(long sec) {
		this.setValue(sec);
	}
	
	public long getHour() {
		return this.value/60/60;
	}
	public long getMin() {
		return this.value/60%60;
	}
	public long getSec() {
		return this.value%60;
	}
	void show(){
		System.out.println(this.getHour()+"시간 " + this.getMin() + "분 " + this.getSec() +"초" );
	}
	
}

