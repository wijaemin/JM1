package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ProductDto;
import jdbc.mapper.ProductMapper;
import jdbc.util.JdbcUtils;

public class Test02 {
	public static void main(String[] args) {
		String sql="select * from product order by no asc";
//		Object[] data={}; 이거는 생략
		
		ProductMapper mapper= new ProductMapper(); //어떻게 만들건지에 대한 방법
		
		JdbcTemplate jdbctTemplate =JdbcUtils.getJdbcTemplate(); //jdbc형식 가져오기
		
		List<ProductDto> list =jdbctTemplate.query(sql,mapper); //product 리스트 리스트에 저장
		
		for(ProductDto dto :list) {
			System.out.println(dto);
		}
		
	}
}
