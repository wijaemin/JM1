package array3;

import java.util.Random;

public class Test07 {

	public static void main(String[] args) {
		/*지뢰찾기 만들기
		 * 지뢰찾기를 다음 요구사항에 맞게 구현
		 * 1.9x9배열을 준비(초급자 난이도)
		 * 2.랜덤으로 10개의 폭탄을 지도에 배치(폭탄은 숫자 9로 설정)
		 * 3.지도출력
		 * 4.폭탄이 아닌 칸의 숫자를 계산(선택)
		 *  	1.폭탄이 배치되지 않은 칸들을 반복하며 계산
		 *  	2.기준 칸 주변 8칸을 조사하여 폭탄의 개수를 카운트
		 *  	3.카운트된 숫자를 현재 위치에 대입
		 * 5.최종 지도 출력(선택)
		 */
			Random r= new Random();
			int[][]map=new int[9][9];
			
			
			
			for(int j=0;j<map.length;j++) {
				for(int i=0;i<map[j].length;i++) {
					map[j][i]=0;
					}
				}
			
			
			for(int b =0;b<10;b++) {
				int x=r.nextInt(9);
				int y=r.nextInt(9);
				if(map[x][y]==0) {
					map[x][y]=99;
				}
			}
			
			
			for(int j=0;j<map.length;j++) {
				for(int i=0;i<map[j].length;i++) {
					System.out.print(map[j][i]);
					System.out.print("\t");
					}
					System.out.println("\n");
					System.out.println();
				}
			
			
			
		
		
		
	}

}
