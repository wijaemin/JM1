package jdbc.app;

import jdbc.dao.BookDao;

public class Test14 {
	public static void main(String[] args) {
		int bookId=11;
		BookDao dao =new BookDao();
		boolean result=dao.delete(bookId);
		
		if(result)System.out.println("책 정보 삭제 완료");
		else System.out.println("존재하지 않는 아이디");
	}
}
