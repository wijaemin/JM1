package jdbc.app;

import java.util.List;

import jdbc.dao.CustomerDao;
import jdbc.dto.CustomerDto;

public class Test00_Customer5 {

	public static void main(String[] args) {
		
		int page=1;
		int size=5;
		
		CustomerDao dao=new CustomerDao();
		List<CustomerDto>list=dao.selectListByPage(page, size);
		
		if(list.isEmpty()) System.out.println("표시할 항목이 X");
		
		else {
			for(CustomerDto dto:list) {
				System.out.println("[" + dto.getCustomerNo() + "]");
				System.out.println(dto.getCustomerId());
				System.out.println(dto.getCustomerContact());
				System.out.println(dto.getCustomerMileage());
				System.out.println(dto.getCustomerLevel());
				System.out.println();
			}
		}

	}
}
