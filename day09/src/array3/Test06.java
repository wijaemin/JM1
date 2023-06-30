package array3;

import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		/* 빙고판 만들기
		 * 
		 * 빙고판은 5x5 사이즈가 기본입니다
		 * 빙고판은 정사각형이며 홀수 크기만 가능합니다.
		 * 빙고판에는 1부터 랜덤한 위치에 배치됩니다
		 * 한 칸에는 한번의 숫자만 배치 가능합니다.
		 * System.out.println(bingo[j][i]);
		 */
		Random r= new Random();
		
		int [][]bingo =new int[5][5];
		int num=1;
		for(int j=0;j<bingo.length;j++) {
			for(int i =0;i<bingo[j].length;i++) {
				bingo[j][i]=num;
				num++;
				}
		}
		
		
		
		for(int j=0;j<bingo.length;j++) {
			for(int i =0;i<bingo[j].length;i++) {
				System.out.print(bingo[j][i]);
				System.out.print("\t");
				}
			System.out.println();
		}
		
		
		
		
		
	}
}
