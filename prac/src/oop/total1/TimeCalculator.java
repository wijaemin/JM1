package oop.total1;

public class TimeCalculator {

	//더하기
	public static Time plus(Time a , Time b) { //Time 클래스인 plus변수를 만든다(플러스는 Time a와 Time b 값을 가져야한다)
		Time result =new Time(a.getValue()+b.getValue()); //
		return result;
	}	//
	public static Time minus(Time a, Time b) {
		if(a.getValue()>b.getValue()) {
			Time result = new Time(a.getValue()-b.getValue());
		return result;
		}
		else {
			Time result = new Time(b.getValue()-a.getValue());
		return result;
		}
	}
}	
