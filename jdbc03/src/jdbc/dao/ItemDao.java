package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ItemDto;
import jdbc.util.JdbcUtils;

public class ItemDao {
	public void insert(ItemDto dto) {
		String sql="insert into item(item_no, item_name, "
				+ "item_price) "
				+ "values(item_seq.nextval, ?, ?)";
		Object[] data = {dto.getItemName(),dto.getItemPrice()};
		
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		
		
	}
}
