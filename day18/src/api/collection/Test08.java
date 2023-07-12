package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
//		네이버 사다리 게임 만들기
//		
//		네이버에서 사다리게임을 검색해서 나오는 게임을 만드세요
//		사다리 타기 관련 그래픽을 제외하고 다음을 만드시면 됩니다
//		1.인원 수 선택
//		2.이름 및 항목 입력
//		3.당첨 결과 출력
		Scanner sc=new Scanner(System.in);
		System.out.print("사람 수 입력 :");
		int people =sc.nextInt();
		
		
		ArrayList<String>nameList =new ArrayList<>();
		for(int i=0;i<people;i++) {//이름 항목 입력
			System.out.print(i+1 + "번째 이름 입력 : ");
			nameList.add(sc.next());
		}
		ArrayList<String>resultList =new ArrayList<>();
		for(int i=0;i<people;i++) {
			System.out.print(i+1 + "번째 항목 입력 : ");
			resultList.add(sc.next());
		}
		Collections.shuffle(resultList);
		System.out.println("<사다리 게임 결과>");
		for(int i=0;i<people;i++) {
			System.out.println(nameList.get(i) + "->" + resultList.get(i));
		}
		sc.close();
		
//		System.out.println(nameList);
//		System.out.println(resultList);
		
		
		
	}
}
