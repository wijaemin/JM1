package oop.inherit7;



public class Test01 {
	public static void main(String[] args) {
		Galaxy23s g1=new Galaxy23s("010-2864-5063","black");
		g1.show();
		g1.call();
		g1.sms();
		g1.samsungPay();
		g1.bixby();
		System.out.println();
		
		GalaxyFold4 g2=new GalaxyFold4("010-4545-5063","white");
		g2.show();
		g2.call();
		g2.sms();
		g2.samsungPay();
		g2.iris();
		System.out.println();
		
		IPhone13 i1=new IPhone13("010-3015-5063","red");
		i1.show();
		i1.call();
		i1.sms();
		i1.itunes();
		i1.siri();
		System.out.println();
		IPhone14 i2=new IPhone14("010-7501-8844","blue");
		i2.show();
		i2.call();
		i2.sms();
		i2.faceTime();
		i2.siri();
	}
}
