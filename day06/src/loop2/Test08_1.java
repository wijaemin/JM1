package loop2;

public class Test08_1 {

	public static void main(String[] args) {
		/*고대 그리스에 현명한 노인이 살고 있었습니다

		왕이 소문을 듣고 찾아서 갖고 싶은게 있으면 뭐든지 줄테니 말해봐라라고 했습니다

		노인이 말합니다
		
		저는 욕심이 없습니다
		30일동안 첫날은 1원만 주세요
		둘째날 부터는 두 배 만큼만 주시면 됩니다
		1.이 노인이 일자별로 받는 돈을 출력
		2.이 노인이 받는 총 금액을 출력
		3.기간이 40일로 늘어나면 얼마를 받는지 출력
		 * 
		 */
		long total=0;
		long money=1;
		for(int day=1;day<=40;day++) {
			total+=money;
			System.out.println(day+"일차 = " + money);
			money*=2;
		
		}
		System.out.println("총 받는 금액 = " + total);
		
		
	}
}
