package api.lang.string2;

public class Test06 {
	public static void main(String[] args) {
		//반드시 1개를 포함해야 되는 경우에 대한 검사
		
		String password = "Khuser1234!";
		
		String regex ="[0-9]";
		
		System.out.println(password.matches(regex));
	}
}
