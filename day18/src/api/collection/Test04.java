package api.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		//이번 주 로또 당첨 예상번호를 추천하는 프로그램을 구현하고 싶습니다.
		//보너스 번호를 제외한 6개의 1~45 범위 내에서 중복없는 숫자를 추첨한 뒤
		//저장소에 저장하고 출력
//		int,long과 같은 원시형은 Generic Type을 사용할 수 없다(null때문)
//		ArrayList<int> a=new ArrayList<>();//error
//		ArrayList<Integer>b=new ArrayList<>();//ok
		
		ArrayList<Integer>lotto= new ArrayList<>();
		
		Random r =new Random();
		
		
	//	lotto.add(number);
		
		
		for(int i=0;i<6;i++) { //6번 추첨
			System.out.println("i= " + i);
			int number=r.nextInt(45)+1; //1~45범위의 숫자 뽑기
			if(lotto.contains(number)) { //로또가 이미 뽑기한 숫자를 포함하고 있으면
				i--; //다시
			}
			else { //아니면
				lotto.add(number);//로또 리스트에 추가
			}
		}
		lotto.sort(null);
		System.out.println(lotto); //로또 리스트 보여주기
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
