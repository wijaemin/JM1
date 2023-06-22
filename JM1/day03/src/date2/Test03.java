package date2;

public class Test03 {
	public static void main(String[]args) {
		/* kh 주유소에서는 휘발유를 1L에 1530원에 팔고 있습니다.
		 * 50000원 주유했을 때 주유되는 휘발유의 양을 출력하세요
		 */
		//입력
		int unitPrice =1530;
		int money =50000;
		//계산
		//int l = money/unitPrice; X
		//double l = money/unitPrice; X
		double l =(double)money/unitPrice;
		System.out.println(l);
	}
}
