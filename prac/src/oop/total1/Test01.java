package oop.total1;

public class Test01 {
	public static void main(String[] args) {
		Time t1= new Time(3,30,40);
		Time t2= new Time(1,70,100);
		Time t3= new Time(50,20);
		Time t4= new Time(30000);
		
		
		t1.show();
		t2.show();
		t3.show();
		t4.show();
		
		Time t5=TimeCalculator.plus(t1,t2);
		t5.show();
	}
}
