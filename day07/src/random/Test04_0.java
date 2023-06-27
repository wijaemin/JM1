package random;

import java.util.Random;

public class Test04_0 {

	public static void main(String[] args) {
		
		
		
		/*어떤 게임 아이템의 강화 확률이 다음과 같습니다.
		 * 
		 * 항목	확률
		 * 성공	20% 0
		 * 유지	60% 123
		 * 실패	20% 4
		 *  
		 *  아이템은 다음과 같은 규칙에 의해서 강화가 이루어집니다.
		 * 
		 * 강화에 성공하면 아이템의 레벨이 1 증가합니다
		 * 강화에 실패하면 유지 또는 실패가 됩니다
		 * 강화 유지가 될 경우 아이템 레벨은 변하지 않습니다
		 * 강화 실패가 될 경우 아이템의 레벨이 1 감소합니다
		 * 아이템 레벨의 상한선은 15이며 더이상 강화가 되지 않습니다
		 * 아이템 레벨의 하한선은 0입니다
		 * 
		 * 1번 강화 할 때마다 1000골드가 들어간다고 할 때 이 아이템을
		 * 1000번 강화 하였을 경우 예상되는 레벨과 소요 골드를 구하여 출력하세요
		 * (단, 15레벨이 되면 강화는 더이상 할 수 없으므로 종료해야합니다.)
		 * 
		 */
		Random r = new Random();
		
		int level=0;
		int count =0;
		int price=1000;
		
		for(int i =0 ; i<500; i++) {
		int reinforce =r.nextInt(5);
		
		if(reinforce == 0) {
			if(level<15) {
				level++;
			System.out.println("성공! 현재 레벨 : " + level);
			}
			if(level == 15) {
			System.out.println("레벨이 15가 되었으므로 강화를 종료합니다.");
			break;
			}
		}
		
		else if(reinforce ==1 ||reinforce ==2 ||reinforce ==3) {
			System.out.println("유지");
		}
		
		else {
			if(level>0) {
				level--;
				}
			System.out.println("실패.. 현재 레벨 : " + level);
			}
		
			count++;
		}
		int total= price *count;
		System.out.println("강화하는데 쓰인 금액은 " +total + "원 입니다.");
	}
}
