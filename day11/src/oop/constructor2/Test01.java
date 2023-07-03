package oop.constructor2;

public class Test01 {

	public static void main(String[] args) {
		//생성자란
		//객체를 생성할 때 필요한 데이터를 전달받는 초기화 전용 구문
		Music m1= new Music("그때 그 순간 그대로(그그그)","WSG워너비","WSG워너비 1집",104250, 91835);
		Music m2= new Music("보고싶었어","WSG워너비","WSG워너비 1집",83127, 90805);
		Music m3= new Music("LOVE DIVE","IVE(아이브)","LOVE DIVE",64590, 174519);
		Music m4= new Music("POP!","나연(TWICE)","IM NAYEON",58826, 70313);
		

		
		m1.show();
		m2.show();
		m3.show();
		m4.show();
		
	}

}
