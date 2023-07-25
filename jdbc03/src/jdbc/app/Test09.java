package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test09 {
	public static void main(String[] args) {
		
		BookDto dto =new BookDto();
		
		dto.setBookTitle("톰과제리");
		dto.setBookAuthor("몰라요");
		dto.setBookPublisher("톰과제리회사");
		dto.setBookId(1);
		
		BookDao dao =new BookDao();
		boolean result =dao.updateBookInfo(dto);
		
		if(result) System.out.println("변경완료");
		else System.out.println("없는 도서번호 입니다.");
	}
}
