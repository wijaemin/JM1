package api.lang.string2;

public class Test07 {
	public static void main(String[] args) {
		//회원가입 +정규표현식 검사
		String memberId="te1234";
		String memberPw="tEstuser1!1";
		String memberName="위재민";
		
		Member member= new Member(memberId,memberPw,memberName);
		member.show();
	}
}
