package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		// 이수근 3 17 1000000 17000000
		String account_owner=sc.next();
		int account_period=sc.nextInt();
		int account_count=sc.nextInt();
		int account_payment =sc.nextInt();
		int account_balance =sc.nextInt();
		
		String sql="insert into account(account_owner, account_period, account_count,"
				+ "account_payment, account_balance) values(?, ?, ?, ?, ?)";
		
		Object[] data = {account_owner, account_period,account_count,account_payment,account_balance};
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql,data);
		
		System.out.println("미션 컴플리트");
		
		
		
		
		
		
		
	}
}
