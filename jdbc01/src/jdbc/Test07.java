package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test07 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.print("게시판 번호 : ");
//		int boardNo=sc.nextInt();
//		sc.nextLine();
		System.out.print("게시판 제목 : ");
		String boardTitle=sc.nextLine();
		System.out.print("게시판 내용 : ");
		String boardContent=sc.nextLine();
		System.out.print("게시판 글쓴이 : ");
		String boardWriter=sc.nextLine();
//		System.out.print("읽은 사람 수  : ");
//		int boardReadcount=sc.nextInt();
		String sql="insert into board(board_no, board_title, "
				+ "board_content, board_writer) values( "
				+ "board_seq.nextval, ?, ?, ?)";	
		Object[] data= {boardTitle, boardContent, 
				boardWriter};
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql,data);
				
		System.out.println("해결");
	}
}
