package array3;


	import java.util.Random;

	public class Test06{
		public static void main(String[] args) {
			//빙고판 만들기
			//= 랜덤한 위치에 1부터 숫자를 배치하는 형태
			
			//배열 생성
			int size = 5;
			
			int[][] bingo = new int[size][size];
			
			//데이터 초기화
			Random r = new Random();
			for(int n=1; n <= size*size; n++) {
				int x = r.nextInt(size);
				int y = r.nextInt(size);
				if(bingo[x][y] == 0) {//처음 넣는 자리라면
					bingo[x][y] = n;
				}
				else {
					n--;
				}
			}
			
			//출력
			for(int i=0; i < size; i++) {
				for(int k=0; k < size; k++) {
					System.out.print(bingo[i][k]);
					System.out.print("\t");
				}
				System.out.println("\n");
			}
		}
	}


