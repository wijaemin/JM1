package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		// 이수근 3 17 1000000 17000000
		System.out.print("예금주 : ");
		String accountOwner=sc.nextLine();
		System.out.print("예금기간(년) : ");
		int accountPeriod=sc.nextInt();
		int accountCount=0;
		System.out.print("1회 예금액 : ");
		int accountPayment =sc.nextInt();
		int accountBalance =0;
		
		//DB 처리
		String sql="insert into account(account_owner, account_period, account_count,"
				+ "account_payment, account_balance) values(?, ?, ?, ?, ?)";
		
		Object[] data = {accountOwner, accountPeriod,accountCount,accountPayment,accountBalance};
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql,data);
		
		System.out.println("ㅗ");
		

		
		
		
		
		
		
	}
}
