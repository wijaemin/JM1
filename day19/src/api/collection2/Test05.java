package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test05 {
	public static void main(String[] args) {
		Set<String> p1 =Set.of("범죄도시3","늑대사냥","드림","퍼펙트게임");
		Set<String> p2 =Set.of("파수꾼","늑대사냥","리바운드","익스트랙션2","드림");
		
		System.out.println("철수 = " +p1);
		System.out.println("영희 = " +p2);
		
		Set<String> inter =new TreeSet<>();
		inter.addAll(p1);
		inter.retainAll(p2);
		System.out.println("둘다 본 영화 = " + inter);
		
		Set<String> chul=new TreeSet<>();
		chul.addAll(p1);
		chul.removeAll(p2);
		System.out.println("철수만 본 영화 = " + chul);
		
		Set<String> yeung=new TreeSet<>();
		yeung.addAll(p2);
		yeung.removeAll(p1);
		System.out.println("영희만 본 영화 = " + yeung);
		
		Set<String> both=new TreeSet<>();
		both.addAll(yeung);
		both.addAll(chul);
		System.out.println("1명만 본 영화 = " + both);
		
		//Set도 전체 출력이 되긴 된다
		//=확장반복(foreach)은 가능
		
		for(String name:both) {
			System.out.println("name = " + name);
		}
		
		
		
		
		
		
	}
}
