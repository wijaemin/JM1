package date2;

public class Test02 {
	public static void main(String[]args) {
		/* BMI(체질량지수)계산기
		 * 네이버에서 bmi계산기 라고 검색하면 참고할만한 프로그램이 나옵니다
		 * 해당 프로그램에서 성별, 바이를 제거하고 만들 예정입니다.
		 * 키가 180, 체중이 80kg인 사람이 있을 때 이 사람의 BMI지수를 구하여 출력
		 * 
		 * 계산공식=체중/키
		 */
		//입력
		int cm = 176;
		int kg= 70;
		
		//계산
		//int m = cm/ 100;
		//float m = cm / 100f;
		double m = cm/100d;
		//double m =(double)cm/100;
		
		//double m = cm * 0.01;
		double totalM = m * m;
		
		double bmi = (((float)((int)((kg/totalM)*100)))/100d);
		
		
		System.out.println(bmi);
		
		
		
		
		
		
	}
}
