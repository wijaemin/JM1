package condition2;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		/* SNS에서는 작성한 글이 몇 초 전에 작성 되었는지에 따라 다음과 같이 출력합니다.
		 * 구분	설명
		 * 방금 전 |작성한지 10초가 되지 않은 글 // 방금 전
		 * ?초 전 |작성한지 10초이상 1분 미만인 글 // 초 (초 전)
		 * ?분 전 |작성한지 1분이상 1시간 미만인 글 // 초/60(분 전)
		 * ?시간 전 |작성한지 1시간이상 1일 미만인 글// 초/3600(시간 전)
		 * ?일 전 |작성한지 1일 이상인 글 // 초/86400(일 전)
		 * 
		 * 사용자에게 '초'를 입력 받아서 기준에 따라 게시글 시간 형식을 출력
		 */
		Scanner sc= new Scanner(System.in);
		System.out.print("초를 입력하세요 : ");
		int second = sc.nextInt();
		
		int min=1*60;
		int hour=min*60;
		int day=hour*24;
		if(second<10) {
			System.out.println("방금 전");
		}
		else if(second<min) {
			System.out.println(second + "초 전");
		}
		else if(second<hour) {
			System.out.println(second/min + "분 전");
		}
		else if(second<day) {
			System.out.println(second/hour + "시간 전");
		}
		else {
			System.out.println(second/day + "일 전");
		}
		sc.close();
	}
}
