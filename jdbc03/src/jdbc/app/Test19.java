package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test19 {

	public static void main(String[] args) {
		int bookId=1;
		BookDao dao =new BookDao();
		BookDto dto =dao.selectOne(bookId);
		
		if(dto==null) {
			System.out.println("찾는 아이디의 도서목록이 없음");
		}
		else {
			System.out.println(dto.getBookId());
			System.out.println(dto.getBookTitle());
			System.out.println(dto.getBookAuthor());
			System.out.println(dto.getBookPublicationDate());
			System.out.println(dto.getBookPrice());
			System.out.println(dto.getBookPublisher());
			System.out.println(dto.getBookPageCount());
			System.out.println(dto.getBookGenre());
		}
		
		
		
		


	}

}
