package array3;

import java.util.Random;

public class Test06_1 {
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
		
		int size= 5;
		int [][]bingo =new int[size][size];
		for(int num=1;num<=size*size ;num++) {
			int x=r.nextInt(size);
			int y=r.nextInt(size);
			if(bingo[x][y]==0) {
			bingo[x][y]=num;
			}
			else {
				num--;
			}
		}
		for(int j=0;j<size;j++) {
			for(int i =0;i<size;i++) {
				System.out.print(bingo[j][i]);
				System.out.print("\t");
				}
			System.out.println("\n");
		}
	}
}
