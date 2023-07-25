package jdbc.app;

import jdbc.dao.CustomerDao;

public class Test00_Customer2 {
	//고객 정보 삭제 프로그램
	public static void main(String[] args) {
		int customerNo=7;
		
		CustomerDao dao =new CustomerDao();
		boolean result =dao.delete(customerNo);
		
		if(result) System.out.println("삭제 완료");
		
		else System.out.println("존재하지 않는 고객 번호");
	}
}
