package api.lang.string2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {
	public static void main(String[] args) {
		//정규표현식(REGular EXpression)
		Scanner sc= new Scanner(System.in);
		
		String number= sc.next();
		
		//boolean isValid=Pattern.matches(검사식, 검사할값);
			//String regex="^[0][1][16-9][0-9]{3,4}[0-9]{4}$";
			String regex="^01[016-9]-?[1-9][0-9]{2,3}[0-9]{4}$";
			//String regex"^01[016-9]-?[0-9]{3,4}[0-9]{4}$"
		//	boolean isValid=Pattern.matches(regex, number);
			boolean isValid=number.matches(regex);
			System.out.println("isValid = " + isValid);
			if(isValid) {
				System.out.println("유효한 전화번호 입니다.");
			}
			else {
				System.out.println("잘못된 전화번호 입니다.");
			}
	}
}
