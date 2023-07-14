package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {
		//투표함 만들기
		Map<String,Integer>vote =new HashMap<>();
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.print("이름 입력 = ");
			String name=sc.next();
			name.replace(" ", "").toLowerCase();
			if(name.equals("종료")) {
				break;
			}
			Integer count=vote.get(name);
			if(count==null) {
				vote.put(name, 1);
			}
			else {
				vote.put(name, count+1);
			}
			System.out.println("[" + name +  "]  현재 " +vote.get(name)+ "표 획득!");
		}
		sc.close();
		System.out.println("<프로그램을 종료합니다?");
		System.out.println(vote);
	}
}
