package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//신규 도서 등록 프로그램(ex:도서관,책방, ...)
		
		//데이터 - book_id는 준비하지 않는다 (시퀀스 활용)
		System.out.print("책 이름 : ");
		String bookTitle=sc.nextLine();
		System.out.print("작가(!@#$ 사용금지)  : ");
		String bookAuthor =sc.nextLine();
		System.out.print("출판일(yyyy-mm-dd) : ");
		String bookPublicationDate =sc.nextLine();
		System.out.print("비용(소수점2자리까지 ex)12.99) : ");
		float bookPrice=sc.nextFloat();
		sc.nextLine();
		System.out.print("출판인 : ");
		String bookPublisher =sc.nextLine();
		System.out.print("페이지 수 : ");
		int bookPageCount =sc.nextInt();
		sc.nextLine();
		System.out.print("장르 : ");
		String bookGenre =sc.nextLine();
		
		
		String sql="insert into book(book_id, book_title, book_author, "
				+ "book_publication_date, book_price, book_publisher, "
				+ "book_page_count, book_genre) values(book_seq.nextval,?, ?, ?, ?, ?, ?, ?)";
		
		Object [] data = {bookTitle,bookAuthor,bookPublicationDate,
				bookPrice,bookPublisher,bookPageCount,bookGenre};
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql,data);
		
		System.out.println("book 추가 완료");
		
		
		sc.close();
		
		
		
	}
}
