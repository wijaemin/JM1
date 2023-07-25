package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CustomerDto;
import jdbc.util.JdbcUtils;

public class CustomerDao {
	
	
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
	public void insert(CustomerDto dto) {
		String sql="insert into customer(customer_no, customer_id, "
			+ "customer_contract, customer_join, customer_purchase, "
			+ "customer_mileage, customer_level) "
			+ "values(customer_seq.nextval,?,?,?,?,?,?)";
		Object[]data= {dto.getCustomerId(),dto.getCustomerContact(), 
		dto.getCustomerJoin(),dto.getCustomerPurchase(), 
		dto.getCustomerMileage(), dto.getCustomerLevel()};
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
