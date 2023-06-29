package array3;

import java.util.Random;

public class Test05_2 {
	public static void main(String[] args) {
		/* 주사위를 5번씩 6회 던진 결과를 저장한 뒤
		 * (1) 회차별 주사위 던진 결과를 출력하시고
		 * (2) 모든 주사위 값의 평균을 출력하세요
		*/
		
		Random r= new Random();
		int[][]dice=new int[6][5];
		int[]totalList=new int[dice.length];
		
		for(int j=0;j<dice.length;j++) {
			for(int i=0;i<dice[j].length;i++) {
				dice[j][i]=r.nextInt(6)+1;
			}
		}
		int total=0;
		int count =0;
		for(int j=0;j<dice.length;j++) {
			for(int i =0;i<dice[j].length;i++) {
				total+=dice[j][i];
				count++;
			}
		}
		System.out.println("total = " + total);
		System.out.println("count = " + count);
		float average=(float)total/count;
		System.out.println("average = " + average);
		
		
		
		
		
		
		for(int j =0;j<dice.length;j++) {
			for(int i =0;i<dice[j].length;i++) {
				System.out.print(dice[j][i]);		
				System.out.print("\t");
			}
			System.out.println();
		}
	
	}
}
