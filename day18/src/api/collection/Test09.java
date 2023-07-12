package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test09 {
	public static void main(String[] args) {
//		한명의 딜러와 네명의 겜블러가 포커를 치려고 합니다.
//		다음 규칙에 따라 포커 카드를 분배하는 프로그램을 구현하고 구현 결과를 출력하세요.
//		1.카드는 네 개의 도형(하트,스페이드,클로버,다이아몬드)이 존재합니다
//		2.각 도형마다 13장의 카드(A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)가 존재합니다.
//		3.총 52장의 카드가 하나의 덱(deck)을 이룹니다.
//		-카드를 실제로 그릴 수 없으므로 다음과 같이 표현합니다.
//		-하트 A는 "하트/A"라고 표현합니다.
//		4.딜러는 게임이 시작되면 카드를 랜덤으로 섞습니다.
//		5.카드가 섞이면 네 명의 플레이어에게 순서대로 카드를 한 장씩 분배합니다.
//		6.카드는 한 사람당 세 장씩 분배합니다.
//		다음과 같이 출력해야합니다.
//		플레이어1 : [하트/A, 클로버/2, 다이아/K]
//		플레이어2 : [클로버/Q, 하트/J, 스페이드/10]
//		플레이어3 : [하트/3, 하트/5, 다이아/7]
//		플레이어4 : [다이아/J, 스페이드/Q, 하트/Q]
//		출력된 결과 옆에 다음의 경우를 분석하여 추가적으로 출력합니다.
//
//		1.숫자가 두 개 같으면 "원 페어"
//		2.숫자가 세 개 같으면 "트리플"
//		
		ArrayList <String>heart =new ArrayList<>();
		heart.add("하트/A");
		for(Integer i=2;i<=10;i++) {
			heart.add("하트/" + i.toString());
		}
		heart.add("하트/J");
		heart.add("하트/Q");
		heart.add("하트/K");
	
		ArrayList <String>spade =new ArrayList<>();
		spade.add("스페이드/A");
		for(Integer i=2;i<=10;i++) {
			spade.add("스페이드/" + i.toString());
		}
		spade.add("스페이드/J");
		spade.add("스페이드/Q");
		spade.add("스페이드/K");
	
		ArrayList <String>clover =new ArrayList<>();
		clover.add("클로버/A");
		for(Integer i=2;i<=10;i++) {
			clover.add("클로버/" + i.toString());
		}
		clover.add("클로버/J");
		clover.add("클로버/Q");
		clover.add("클로버/K");
	
		ArrayList <String>diamond =new ArrayList<>();
		diamond.add("다이아/A");
		for(Integer i=2;i<=10;i++) {
			diamond.add("다이아/" + i.toString());
		}
		diamond.add("다이아/J");
		diamond.add("다이아/Q");
		diamond.add("다이아/K");
	
		ArrayList <String> deck =new ArrayList<>();
		deck.addAll(heart);
		deck.addAll(spade);
		deck.addAll(clover);
		deck.addAll(diamond);
		
		Collections.shuffle(deck);
		List<String>player1=deck.subList(0, 3);
		List<String>player2=deck.subList(3, 6);
		List<String>player3=deck.subList(6, 9);
		List<String>player4=deck.subList(9, 12);
				
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);
		System.out.println(player4);
		
		
		
		
		
	}
}
