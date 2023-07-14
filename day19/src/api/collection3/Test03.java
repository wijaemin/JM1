package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03 {
	public static void main(String[] args) {
		Map<String,Integer>vote =new TreeMap<>();
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.print("이름 입력 = ");
			String name=sc.next();
			
			if(name.equals("종료")) {
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
		}
		System.out.println("프로그램을 종료합니다");
		System.out.println(vote);
	}
}
