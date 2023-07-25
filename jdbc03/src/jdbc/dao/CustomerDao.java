package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CustomerDto;
import jdbc.util.JdbcUtils;


public class CustomerDao {
	//C(등록)메소드
	public void insert(int customerNo, String customerId, 
		String customerContact, String customerJoin, 
		String customerPurchase, String customerMileage, 
		String customerLevel) {
		String sql="insert into customer(customer_no, customer_id, "
			+ "customer_contract, customer_join, customer_purchase, "
			+ "customer_mileage, customer_level) "
			+ "values(customer_seq.nextval,?,?,?,?,?,?)";
		Object[] data= {customerId,customerContact,customerJoin, 
		customerPurchase,customerMileage,customerLevel};
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		}
	//바람직한 형태의 등록 메소드
	public void insert(CustomerDto dto) {
		String sql="insert into customer(customer_no, customer_id, "
			+ "customer_contact, customer_join, customer_purchase, "
			+ "customer_mileage, customer_level) "
			+ "values(customer_seq.nextval,?,?,?,?,?,?)";
		Object[]data= {dto.getCustomerId(),dto.getCustomerContact(), 
		dto.getCustomerJoin(),dto.getCustomerPurchase(), 
		dto.getCustomerMileage(), dto.getCustomerLevel()};
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		}
	//U(수정)메소드
	public boolean update(CustomerDto dto) {
		String sql="update customer set customer_id =? , "
				+ "customer_contact =? where customer_no =?";
		Object[]data= {dto.getCustomerId(),dto.getCustomerContact(), 
				dto.getCustomerNo()};
		
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		int result = jdbcTemplate.update(sql,data);
		
		return result>0;
	}
	//D(삭제) 메소드
		//- 삭제 메소드는 Primary key(기본키)를 이용하여 하나씩 지운다
		//- 조건에 따라서 삭제가 안될 수 있기 때문에 결과를 반환해야한다
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
