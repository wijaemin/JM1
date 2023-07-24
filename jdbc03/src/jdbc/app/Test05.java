package jdbc.app;

import java.sql.Date;

import jdbc.dao.ProductDao;
import jdbc.dto.ProductDto;

public class Test05 {
	public static void main(String[] args) {
		ProductDto dto= new ProductDto();
		dto.setName("포카칩");
		dto.setType("과자");
		dto.setPrice(2000);
		dto.setMade(Date.valueOf("2020-05-13"));
		dto.setExpire(Date.valueOf("2020-07-19"));
		
		ProductDao dao=new ProductDao();
		dao.insert(dto);
		System.out.println("등록완료");
	}
	
}
