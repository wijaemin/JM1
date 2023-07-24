package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03 {
	public static void main(String[] args) {
		BookDto dto =new BookDto();
		dto.setBookTitle("바꿀제목2");
		dto.setBookAuthor("바꿀작가");
		dto.setBookPublicationDate("2022-01-01");
		dto.setBookPrice(13.12f);
		dto.setBookPublisher("바꿀몰라");
		dto.setBookPageCount(123);
		dto.setBookGenre("아무거나:");
		
		BookDao dao =new BookDao();
		dao.insert(dto);
		System.out.println("등록완료");
	}
}
