package loop3;

import java.util.Random;
import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) {
		/*업다운 게임
		 * 업다운 게임은 숫자를 맞추는 게임이다.
		 * 
		 * 1.술래가 1부터 1000사이의 정수 중에서 랜덤으로 하나의 숫자를 정합니다.
		 * 2.술래가 아닌 사람이 정답을 예측합니다.
		 * 3.예측한 정답과 실제 정답이 같으면 끝
		 * 4.예측한 정답과 실제 정답이 같지 않으면 '업' 또는 '다운'을 외친다
		 *		1.'업을 외치는 경우는 예측한 정답보다 실제 정답이 더 큰 수 일 경우
		 *		2.'다운을 외치는 경우는 예측한 정답보다 실제 정답이 더 작은 수 일 경우
		 *
		 * 컴퓨터가 술래를 하고, 사용자가 정답을 맞추는 형태의 프로그램을 구현하세요.
		 * 정답을 맞추면 몇 번 만에 맞췄는지 카운트하여 출력하시기 바랍니다.
		 */
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
	
		int tagger =r.nextInt(1000)+1;
		int count = 0;
		while(true) {
		System.out.print("숫자를 입력하세요 : ");
		int me =sc.nextInt();
		count++;
		if(tagger ==me) {
			System.out.println(count + "번 만에 정답을 맞췄습니다!");
			break;
		}
		else if(tagger>me) {
			System.out.println("업");
		}
		else {
			System.out.println("다운");
			}
		}
		sc.close();
	}
}
