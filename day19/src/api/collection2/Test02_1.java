package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02_1 {
	public static void main(String[] args) {
		Random r= new Random();
		Set <Integer> lotto=new TreeSet<>();
		
		while(lotto.size()<6) {
			int num=r.nextInt(45)+1;
			lotto.add(num);
		}
		
		System.out.println(lotto);
	}
}
