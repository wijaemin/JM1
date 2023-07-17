package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		Map<String,Integer>vote =new HashMap<>();
		
		Scanner sc= new Scanner(System.in);
<<<<<<< HEAD
		
		while(true) {
			System.out.print("이름 입력 = ");
			String name=sc.next();
			
			if(name.contains("종료")) {
				break;
			}
			
			if(vote.containsKey(name)) {
				int count=vote.get(name);
				count++;
				vote.put(name, count);
				System.out.println("[" + name +  "]  현재 " +count+ "표 획득!");
			}
			else {
				vote.put(name, 1);
				
				System.out.println("[" + name +  "]  현재 1표 획득!");
			}
=======
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
			
>>>>>>> branch 'main' of https://github.com/wijaemin/JM1.git
		}
<<<<<<< HEAD
		System.out.println("프로그램을 종료합니다");
=======
		sc.close();
		vote.remove("종료");
		System.out.println("프로그램을 종료합니다.");
		System.out.println();
>>>>>>> branch 'main' of https://github.com/wijaemin/JM1.git
		System.out.println(vote);
	}
}
