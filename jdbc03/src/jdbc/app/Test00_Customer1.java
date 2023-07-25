package jdbc.app;

import jdbc.dao.CustomerDao;
import jdbc.dto.CustomerDto;

public class Test00_Customer1 {

	//고객 수정 프로그램
	public static void main(String[] args) {
		CustomerDto dto=new CustomerDto();
		dto.setCustomerNo(7);
		dto.setCustomerId("sotired123");
		dto.setCustomerContact("010-1122-3344");
		CustomerDao dao=new CustomerDao();
		boolean result=dao.update(dto);
		if(result){
		System.out.println("수정 완료");
		}
		else {
		System.out.println("존재하지 않는 고객 번호");
		}
	}
}
