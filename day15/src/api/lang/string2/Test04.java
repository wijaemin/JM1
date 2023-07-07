package api.lang.string2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id=sc.next();
		
		String regex="^[a-z][a-z0-9\\-_]{4,19}$";
		
		//boolean isValid =Pattern.matches(regex, id);
		//System.out.println(isValid);
		if(id.matches(regex)) {
			System.out.println("이 아이디는 생성 가능합니다.");
		}
		else {
			System.out.println("5~20자의 영문 소문자,숫자와 특수기호(_),(-)만 사용 가능합니다.");
		}
		
	}
}
