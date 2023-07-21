package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test08 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("아이디 입력(중복금지)(영소문자 시작, "
				+ "영소문자 영어만 입력)(8자이상 25자 이하) : ");
		String memberId=sc.nextLine();
		System.out.print("비밀번호 입력(영어대소문자,숫자,!@#$"
				+ " 무조건 1번씩은 써야함	(8자 이상 20자 이하) : ");
		String memberPw=sc.nextLine();
		System.out.print("닉네임 입력(2자 이상 10자 이하) : ");
		String memberNickname =sc.nextLine();
		System.out.print("생일 입력(중복금지)(YYYY-MM-DD) : ");
		String memberBirth =sc.nextLine();
		System.out.print("이메일 입력: ");
		String memberEmail =sc.nextLine();
//		String memberEmail ="null";
		System.out.print("전화번호 입력(예시:01012345678) : ");
		String memberContact =sc.nextLine();
//		String memberLevel="";
//		int memberPoint =0;
//		String memberJoin="";
		
		String sql="insert into member(member_id, member_pw, "
				+ "member_nickname, member_birth,member_email,"
				+ "member_contact) values( "
				+ "?, ?, ?, ?, ?, ? )";
		Object[] data= {memberId, memberPw, memberNickname, 
				memberBirth,memberEmail,memberContact};
		
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
