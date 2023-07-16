package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03 {
	public static void main(String[] args) {
		Map<String,Integer>vote =new HashMap<>();
		
		Scanner sc= new Scanner(System.in);
//		String id="피카츄";

		while(true) {
			System.out.print("이름 입력 = ");
			String name=sc.next();
			
			if(vote.containsKey(name)) {
				int next=vote.get(name);
				vote.put(name, next+1);
				System.out.println("[" + name + "] 현재 " + vote.get(name) + "표 획득!");
				System.out.println();
			}
			else {
				int count=1;
				vote.put(name, count);
				if(vote.containsKey("종료")) {
					System.out.println();
					break;
				}
				System.out.println("[" + name + "] 현재 " +vote.get(name)+ "표 획득!");
				System.out.println();
			}
			
		}
		sc.close();
		vote.remove("종료");
		System.out.println("프로그램을 종료합니다.");
		System.out.println();
		System.out.println(vote);
	}
}
