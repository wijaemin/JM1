package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02 {
	public static void main(String[] args) {
		Random r= new Random();
		Set <Integer> lotto=new TreeSet<>();
		
			for(int i=0;i<6;i++) { //로또 번호 6개 추첨
				int num=r.nextInt(45)+1; //번호는 1~45
//				System.out.println(num);
				if(lotto.contains(num)) { //번호가 이미 로또에 있는 번호면 
					i--; //다시 뽑기
				}
				else {
					lotto.add(num); //로또에 뽑은 번호 추가
				}
			}
		System.out.println(lotto);
	}
}
