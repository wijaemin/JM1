package jdbc.app;

import java.util.List;

import jdbc.dao.CustomerDao;
import jdbc.dto.CustomerDto;

public class Test00_Customer4 {

	public static void main(String[] args) {
		//고객 번호를 이용하여 상세 조회
		
		//데이터
		int customerNo =5;
		
		//처리
		CustomerDao dao=new CustomerDao();
		CustomerDto dto=dao.selectOne(customerNo);
		
		//출력
		if(dto==null) {
			System.out.println("찾는 번호의 고객은 없습니다");
		}
		else {
			System.out.println(dto.getCustomerLevel());
			System.out.println(dto.getCustomerMileage());
			System.out.println(dto.getCustomerJoin());
		}

	}
}
