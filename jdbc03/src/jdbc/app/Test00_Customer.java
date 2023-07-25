package jdbc.app;

import jdbc.dao.CustomerDao;
import jdbc.dto.CustomerDto;

public class Test00_Customer {

	public static void main(String[] args) {
		CustomerDto dto=new CustomerDto();
		dto.setCustomerId("wijaemin");
		dto.setCustomerContact("010-4444-5555");
		dto.setCustomerJoin("2000-01-01");
		dto.setCustomerPurchase("2002-02-02");
		dto.setCustomerMileage(4500);
		dto.setCustomerLevel("VVIP");
		
		CustomerDao dao=new CustomerDao();
		dao.insert(dto);
		System.out.println("등록 완료");
	}
}
