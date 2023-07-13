package api.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		Set<Integer>like =new TreeSet<>();
		while(true) {
			System.out.print("번호를 입력하세요 : ");
			int num=sc.nextInt();
			if(num<=0) {
				break;
			}
			if(like.contains(num)) {
				like.remove(num);
				System.out.println(num +"번 글에 좋아요를 취소했습니다");
			}
			else {
				like.add(num);
				System.out.println(num + "번 글에 좋아요를 눌렀습니다");
			}
			
			
		}
		System.out.println("<좋아요를 설정한 글 번호>");
		System.out.println(like);
		
		
		
		
		
	}
}
