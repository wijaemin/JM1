package random;

import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
		//윷놀이 한 턴 구현
		//(약속) 빽도 = 0, 도 = 1/2/3 개 = 4/5/6/7/8/9 걸 =10/11/12/13 윳 = 14 모 = 15
		
		Random r = new Random();
		//int yut = 0부터 5까지;
		//int yut = 0부터 6개;
		int yut = r.nextInt(16);
		System.out.println("yut = " + yut);
		
		switch(yut) {
		
		case 0 : System.out.println("빽도"); break;
		case 1,2,3 : System.out.println("도"); break;
		case 4,5,6,7,8,9 : System.out.println("개"); break;
		case 10,11,12,13 : System.out.println("걸"); break;
		case 14 : System.out.println("윷"); break;
		case 15 : System.out.println("모"); break;
		}	
	}
}
