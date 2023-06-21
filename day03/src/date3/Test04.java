package date3;

public class Test04 {
	public static void main(String[] args) {
		//청소년 판정 프로그램
		/*청소년 = 14살 이상 19세 이하
		 * 
		 */
		int age =15;
		//boolean teen = 14<=age<=19; 안됨
		boolean teen = 14<=age && age<=19;
		
		
		//boolean free = 8세 미만 또는 65세 이상;
		boolean free = age <8 || age>=65;
		
		//논리연산 -논리끼리 계산하기 위한 기호
		//&& (and연산) - 왼쪽과 오른쪽이 모두 참인 경우 참(참참참)
		// || (or 연산) - 왼쪽과 오른쪽이 모두 거짓인 경우 거짓(거짓 거짓 거짓)
		System.out.println(teen);
		System.out.println(free);
		
		
		
		
	}
}
