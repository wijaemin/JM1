package api.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test04_1 {
	public static void main(String[] args) {

		Set<Integer> a=Set.of(30,50,20);
		Set<Integer> b= Set.of(30,20,40,10);
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
//		합집합 (중복 제거)
		Set<Integer> union=new TreeSet<>();
		union.addAll(a);
		union.addAll(b);
		System.out.println("합집합(중복 제거) = " +union);
//		합집합 (중복)
		List<Integer>union2 = new ArrayList<>();
		union2.addAll(a);
		union2.addAll(b);
		System.out.println("합집합(중복) = " + union2);
//		교집합
		Set<Integer> inter= new HashSet<>();
		inter.addAll(a);
		inter.retainAll(b);
		System.out.println("교집합 = " + inter);
//		차집합(a에만 있는거만 출력)
		Set<Integer> a1=new HashSet<>();
		a1.addAll(a);
		a1.removeAll(b);
		System.out.println("a만 있는것 = " + a1);
//		차집합(b에만 있는거만 출력)
		Set<Integer> b1=new HashSet<>();
		b1.addAll(b);
		b1.removeAll(a);
		System.out.println("b만 있는것 = " + b1);
		
	}
}
