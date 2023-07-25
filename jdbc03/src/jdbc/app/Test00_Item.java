package jdbc.app;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test00_Item {
	public static void main(String[] args) {
		ItemDto dto=new ItemDto();
		dto.setItemName("아이템");
		dto.setItemPrice(1200);
		ItemDao dao =new ItemDao();
		dao.insert(dto);
		System.out.println("등록완료");
		
	}
}
