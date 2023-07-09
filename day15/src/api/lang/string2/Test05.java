package api.lang.string2;

public class Test05 {
	public static void main(String[] args) {
		
		String birth = "1999-04-31";
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		
		if(birth.matches(regex)) {
			System.out.println("올바른 생년월일");
		}
		else {
			System.out.println("잘못된 생년월일");
		}
		
	}
}