package input;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
	/* 사용자에게 다음 정보를 입력받아
	 * 총점(tot)과 평균(avg)을 구하여 출력
	 * 
	 * 국어 점수(kr)
	 * 영어 점수(eng)
	 * 수학 점수(mat)
	 * 
	 */
	Scanner sc = new Scanner(System.in);
	System.out.print("국어 점수를 입력하세요: ");
	int kr =sc.nextInt();
	System.out.print("영어 점수를 입력하세요: ");
	int eng =sc.nextInt();
	System.out.print("수학 점수를 입력하세요: ");
	int mat =sc.nextInt();
	
	sc.close();

	int sub=3;
	
	int tot=kr+eng+mat;
	System.out.println("총 점수는 " + tot + "점 입니다.");
	float avg=(float)tot/sub;
	System.out.println("평균 점수는 " + avg + "점 입니다.");

	}
}
