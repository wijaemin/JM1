package api.lang.string2;

public class Test05_1 {
	public static void main(String[] args) {
		//큰달/작은달/2월을 정규표현식으로 구분
		
		String birth = "1999-02-29";
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$";
		
		if(birth.matches(regex)) {
			System.out.println("올바른 생년월일");
		}
		else {
			System.out.println("잘못된 생년월일");
		}
		
	}
}