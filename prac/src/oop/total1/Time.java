package oop.total1;

public class Time {
	//필드- 시간을 초로 저장할 수 있는 필드 1개만 생성
	private long value; 
	
	//setter,getter 메소드
	public void setValue(long value) {
		if(value<0L)return; //value가 0보다 작으면 반환
		this.value=value; 
	}
	
	public long getValue() {
		return value;
	}
	//생성자
	//[1]시간/분/초를 설정할 수 있는 생성자
	public Time(long hour,long minute,long second) {	//시간 분 초를 입력받는다
		long total=hour*60*60+minute*60+second; //total에 시간과 분을 초로 변환한 값과 초를 넣는다
		this.setValue(total); //total값은 Value로 들어간다
	}
	//[2]분/초 를 설정할 수 있는 생성자
	public Time(long minute,long second) { //분 초를 입력받는다
		long total =minute*60+second; //total에 분을 초로 변환한 값과 초를 넣는다
		this.setValue(total); //total값은 Value로 들어간다
	//[3]초를 설정할 수 있는 생성자
	}
	public Time(long second) { //초를 입력받는다
		this.setValue(second); // 초 값은 Value로 들어간다
	}
	
	//가상의 getter 메소드
	
	public long getHour() { 
		return this.value/60/60; // value(초)값을 시간단위로 바꿔서 getHour()를 호출할때 불러온다
	}
	public long getMinute() { 
		return this.value/60%60; //value(초)값을 분 단위로 바꿔서 getMinute()를 호출할 때 불러온다
	}
	public long getSecond() {
		return this.value%60; //value(초)값을 초만 남기고 getSecond()를 호출할 때 불러온다
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

