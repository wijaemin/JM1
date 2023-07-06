package oop.multi2;


public class Test01 {
	public static void main(String[] args) {
		Drone d=new Drone();
		//Flyable d=new Drone(); //업캐스팅
		//Electronic d=new Drone(); //업캐스팅
		//Transportation d=new Drone(); //업캐스팅
		//Reserve d =new Drone();//상속관계가 아니므로 업캐스팅 불가능
		d.move();
		d.on();
		d.off();
		d.fly();
		System.out.println();
		
		
		
		
		
		
		Transportation ts = d;//업캐스팅
//		if(t가 드론일 경우만){
		if(ts instanceof Drone){
//		Drone dd= t; //다운캐스팅(에러)
		Drone dd= (Drone)ts; //다운캐스팅
		
		dd.on();
		dd.fly();
		dd.move();
		dd.off();
		}
		Airplane a=new Airplane();
		a.move();
		a.fly();
		a.reservation();
		System.out.println();
		
		Train t= new Train();
		t.move();
		t.reservation();
		System.out.println();
		
		Bus b = new Bus();
		b.move();
		System.out.println();
		
		Kickboard k= new Kickboard();
		k.move();
		k.on();
		k.off();
	}
}
