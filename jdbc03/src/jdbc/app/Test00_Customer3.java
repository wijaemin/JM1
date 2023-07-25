package jdbc.app;

import java.util.List;

import jdbc.dao.CustomerDao;
import jdbc.dto.CustomerDto;

public class Test00_Customer3 {

	public static void main(String[] args) {
		//저장된 고객 정보를 모두 불러오기
		CustomerDao dao=new CustomerDao();
		List<CustomerDto>list=dao.selectList();
		
		//list를 활용해서 하고싶은 작업을 하면 된다(반복문, 조건. 출력)
		System.out.println("조회 결과 수 : " +list.size());
		for(CustomerDto dto:list) { //조건 달기
			System.out.println(dto); //전체 출력
//			System.out.println(dto.getCustomerMileage()); //개별 출력
		}
	}
}
