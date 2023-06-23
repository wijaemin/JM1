package condition;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		/*과속단속 카메라 프로그램
		KH전자에서 만든 과속단속 카메라는 다음 규칙에 따라서 벌금을 계산합니다
		50km를 초과하는 속도로 달리는 자동차를 단속
		기본 벌금은 30000원으로 설정
		벌금은 제한속도보다 10km 이상 빨라질 때마다 10000원씩 증가
		자동차 속도를 입력값으로 설정한 뒤 예상되는 벌금을 출력(과속이 아니면 벌금은 없습니다) 
		 */
		
		Scanner sc= new Scanner(System.in);
		
		
		System.out.print("속도(km)를 입력하세요 : ");
		//입력
		int km =sc.nextInt();
		int penalty = 30000;
		int limit= 50;
		int total;
		//출력
		if(km>limit) {
			total=penalty+(km-limit)/10*10000;	
			
		}
		else {
			total=0;
		}
		
		System.out.println("예상되는 벌금은 " +total + "원 입니다.");
		
		sc.close();
	}
}
