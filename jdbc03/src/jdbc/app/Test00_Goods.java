package jdbc.app;

import jdbc.dao.GoodsDao;
import jdbc.dto.GoodsDto;

public class Test00_Goods {
public static void main(String[] args) {
	GoodsDto dto=new GoodsDto();
	dto.setName("하이");
	dto.setType("안녕");
	dto.setPrice(1000);
	GoodsDao dao=new GoodsDao();
	
	dao.insert(dto);
	
	System.out.println("등록완료");
	
}
}
