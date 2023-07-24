package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02 {
	public static void main(String [] args) {
		int bookId = 11;
		String bookTitle = "바꿀제목";
		double bookPrice = 123.99;
		
		//DB처리 -자바는 자동 COMMIT 모드를 사용한다
		String sql = "update book set book_title = ?, book_price = ? where book_id = ?";
		Object[] data = {bookTitle, bookPrice, bookId};
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##kh");
		dataSource.setPassword("KH");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int result = jdbcTemplate.update(sql, data);
		System.out.println("result = " + result);
		if(result>0) {
			System.out.println("임무 완료!");
			
		}
		else {
			System.out.println("없는 번호입니다");
		}
		
	}
}
