package array3;

import java.util.Random;

public class Test05_3 {
	public static void main(String[] args) {
		/* 주사위를 5번씩 6회 던진 결과를 저장한 뒤
		 * (1) 회차별 주사위 던진 결과를 출력하시고
		 * (2) 모든 주사위 값의 평균을 출력하세요
		*/
		
		Random r= new Random();
		int[][]dice=new int[6][5]; //5번씩 6회 여기서 / 회가 1차원 배열 / 번이 2차원배열
		float averList=0;
		int totalList=0;
		int total=0;
		int count=0;
		for(int j=0;j<dice.length;j++) {
			for(int i=0;i<dice[j].length;i++) {
				
				dice[j][i]=r.nextInt(6)+1;
				
				total+=dice[j][i];
				totalList+=dice[j][i];
				
				System.out.print(dice[j][i]);
				System.out.print("\t");
				count++;		
			}
			System.out.print((j+1) + "회차 주사위 값의 합 = " + totalList);
			System.out.print("\t");
			averList=(float)totalList/dice[j].length;
			System.out.println((j+1) + "회차 주사위 값들의 평균 = " + averList);
			System.out.println();
			totalList=0;
			averList=0;
		}
		System.out.println("모든 주사위 값의 합 = " + total);
		System.out.println("총 던진 횟수 = " + count);
		float average=(float)total/count;
		System.out.println("모든 주사위 값의 평균 = " + average);
	}
}
