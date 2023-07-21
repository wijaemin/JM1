package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03 {
	public static void main(String[] args) {
		int boardNo =1;
		String boardTitle="아무거나";
		String boardContent="아무거나바꿔";
		String boardWriter="test0202";
		int boardReadcount=10;
		
		String sql="update board set board_title = ?, board_content = ?, "
				+ "board_writer = ?, board_readcount = ? where board_no = ?";
		
		Object [] data= {boardTitle, boardContent, boardWriter, boardReadcount,boardNo};
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
