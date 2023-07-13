package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03 {
	public static void main(String[] args) {
		Map<String,Integer>vote =new TreeMap<>();
		
		Scanner sc= new Scanner(System.in);
//		System.out.print("아이디 입력 = ");
//		String id=sc.next();
		String id="피카츄";
		
		
		if(vote.containsKey(id)) {
			System.out.println("[" + id +  "]  현재 " +id.equals(vote.get(id)) + "표 획득!");
		}
		else {
			System.out.println("[" + id +  "]  현재 " +id.equals(vote.get(id)) + "표 획득!");
		}
		System.out.println(vote);
		
	}
}
