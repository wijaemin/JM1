package api.lang.String;

import java.util.Scanner;

public class Test06_1 {
public static void main(String[] args) {
	//첫 번째 제시어를 '바나나'로 설정해두고
	
	//사용자에게 단어를 입력받아서 쿵쿵따 게임
	Scanner sc=new Scanner(System.in);
	
	
	//System.out.print("단어를 입력하세요 ->");
	//String text=sc.next();
	//System.out.println(text.charAt(text.length()-1));
	
	String first ="바나나";
	while(true) {
		
	System.out.println(first + "! 쿵쿵따!");
	String input =sc.next();
	//판정
	//[1] 3글자인지 판정
	//[2] 이어지는지 판정
		if(input.length()==3 && first.charAt(2)==input.charAt(0)) {
			first=input;//제시어 교체
			}	
		else {
			System.out.println("게임오버");
			break;
			}
		}
		sc.close();
	}
}
