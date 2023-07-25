package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.CustomerDto;

public class CustomerMapper implements RowMapper<CustomerDto>{

	@Override
	public CustomerDto mapRow(ResultSet rs, int idx) throws SQLException {
		CustomerDto dto=new CustomerDto();
		dto.setCustomerNo(rs.getInt("customer_no"));
		dto.setCustomerId(rs.getString("customer_id"));
		dto.setCustomerContact(rs.getString("customer_contract"));
		dto.setCustomerJoin(rs.getString("customer_join"));
		dto.setCustomerPurchase(rs.getString("customer_purchase"));
		dto.setCustomerMileage(rs.getInt("customer_mileage"));
		dto.setCustomerLevel(rs.getString("customer_level"));
		return dto;
	}

}
