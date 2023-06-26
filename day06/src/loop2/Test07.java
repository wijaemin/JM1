package loop2;

public class Test07 {
	public static void main(String[] args) {
		/*여름을 맞이하여 다이어트 계획을 다음과 같이 세웠습니다.

		1.30일동안 매일 하루에 20개씩 푸시업을 한다
		2.30일동안 첫날은 10개, 둘째날부터는 3개씩 늘려가며 한다
		1번과 2번에 대한 각각의 푸시업 개수 합계를 구하여 출력하세요
		*/
		int push=0;
		for(int i=1;i<=30;i++) {
			System.out.println(i+"일차 : 20개");
			push+=20;
		}
		System.out.println("1번의 푸쉬업 개수 =" + push);
		System.out.println("=======================");
		int pushUp = 10;//시작은 10개(추천)
		int total = 0;
		
		for(int day=1; day <= 30; day++) {
			System.out.println(day+"일차 : " + pushUp + "개");
			total += pushUp;//total을 pushUp 개수만큼 증가 처리
			pushUp += 3;//3개씩 증가
		}
		
		System.out.println("총 푸시업 개수 = " + total);
		
		int result= push+total;
		System.out.println("1번과 2번의 푸쉬업 개수 합계 : " + result);
		
		
		
		
	}
}
	