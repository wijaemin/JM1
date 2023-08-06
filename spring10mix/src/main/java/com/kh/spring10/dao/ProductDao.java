package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ProductDto;
import com.kh.spring10.mapper.ProductMapper;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ProductMapper mapper;
	
	
	
	public int sequence() {
		String sql="select product_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql,int.class );
	}
	
	public void insert(ProductDto dto) {
		String sql="insert into product(no,name,type,price,made,expire)"
				+ "values(?,?,?,?,sysdate,sysdate+30)";
		Object[]data= {dto.getNo(), dto.getName(), dto.getType(), dto.getPrice()};
		
		jdbcTemplate.update(sql,data);
	}
	public boolean update(ProductDto dto) {
		String sql="update product set name = ?, "
				+ "type = ?, price = ?, made = ?, "
				+ "expire = ? where no = ?";
		Object[]data= {dto.getName(), dto.getType(), dto.getPrice(), 
				dto.getMade(), dto.getExpire(), dto.getNo()};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	public boolean delete(int no) {
		String sql="delete product where no = ?";
		Object[]data= {no};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	public List<ProductDto>selectList(){
		String sql="select * from product order by no asc";
		return jdbcTemplate.query(sql,mapper);
	}
	public ProductDto selectOne(int no) {
		String sql="select * from product where no=?";
		Object[]data= {no};
		List<ProductDto>list=jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null:list.get(0);
	}
}
