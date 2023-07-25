package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test08 {
	public static void main(String[] args) {
		BookDto dto =new BookDto();
		dto.setBookPrice(13.99f);
		dto.setBookId(1);
		
		BookDao dao =new BookDao();
		
		boolean result=dao.updateBookPrice(dto);
		
		if(result) {
			System.out.println("변경완료");
		}
		else System.out.println("없는 도서번호입니다.");
	}
	
}
