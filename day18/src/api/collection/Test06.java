package api.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test06 {
	public static void main(String[ ] args) {
//		끝말잇기 게임 만들기
//		
//		제시어는 자바로 정한 뒤 사용자에게 2~6글자의 한글 단어를 입력받아
//		끝말잇기 게임을 진행하세요
//		
//		입력한 모든 단어는 기록해두어야 하며 만약 다음 조건에 해당되면 게임오버 처리
//		및 여태까지 입력했던 단어들을 순차적으로 출력
//		
//		-제시어와 이어지지 않는 단어 입력
//		-한글2~6글자가 아닌 단어 입력
//		-띄어쓰기 허용하지 않음
		
		Scanner sc= new Scanner(System.in);
		ArrayList<String>list = new ArrayList<>(); //단어들 넣어두는 곳
		String regex="^[가-힣]{2,6}$";
		String start="자바"; //시작 단어
		System.out.println("첫번째 단어 : "+ start );
		while(true) {
			System.out.print(start + "-> : ");
			String input =sc.next(); //내가 입력한 단어
			boolean result=input.matches(regex);
			if(result==false) {
				System.out.println("게임오버");
				break;
			}
			else if(start.charAt(start.length()-1)!=input.charAt(0)) {
				System.out.println("게임오버");
				break;
			}
			else {
				list.add(input);
				start=input;
			}
		}
		for(String word:list) {
			System.out.println(word);
		}
		
		
		
		
	}
}
