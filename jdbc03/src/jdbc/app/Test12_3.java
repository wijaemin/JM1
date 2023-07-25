package jdbc.app;

import jdbc.dao.MemberDao;

public class Test12_3 {
	public static void main(String[] args) {
		String memberId="minialp2002";
		
		MemberDao dao =new MemberDao();
		boolean result= dao.delete(memberId);
		if(result) System.out.println("아이디 정보 삭제 완료");
		else System.out.println("존재하지 않는 아이디");
	}
}
