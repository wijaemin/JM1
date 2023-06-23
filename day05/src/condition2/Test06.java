package condition2;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		/* BMI 계산기 개조
		 * 
		 * 사용자에게 '신장'과'체중'을 입력받아 BMI수치를 계산하고
		 * 다음 기준에 따라 비만도 판정까지 수행하도록 구현하세요
		 * (BMI 계산 공식은 이전 문제를 참조하세요)
		 *범위		판정
		 *18.5미만			저체중
		 *18.5이상 23미만 정상
		 *23이상 25미만	과체중
		 *25이상 30미만  	경도비만
		 *30이상				중등도비만
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("키(ex:176cm = 176)를 입력하세요 : ");
		float cm = sc.nextFloat();
		System.out.print("몸무게를 입력하세요 : ");		
		float weight = sc.nextFloat();
		
		float m= cm/100F;
		
		
		float BMI =weight/m/m;
		
		String result;
		
		if(BMI<18.5) {
			result=BMI + "/저체중";
		}
		else if(BMI<23) {
			result=BMI + "/정상";
		}
		else if(BMI<25) {
			result=BMI + "/과체중";
		}
		else if(BMI<30) {
			result=BMI + "/경도비만";
		}
		else  {
			result=BMI + "/중등도비만";
		}
		
		System.out.println(result);
		sc.close();
	}
}
