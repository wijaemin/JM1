package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CustomerDto;
import jdbc.mapper.CustomerMapper;
import jdbc.util.JdbcUtils;

//DAO클래스
//=Data Access Object. DB담당 처리반
//=해당 테이블에 필요한 기능들을 '메소드'로 구현
//=기본적으로 C(등록), R(목록), R(상세), U(수정), D(삭제)가 필요


public class CustomerDao {
	//C(등록)메소드
	public void insert(int customerNo, String customerId, 
		String customerContact, String customerJoin, 
		String customerPurchase, String customerMileage, 
		String customerLevel) {
		String sql="insert into customer(customer_no, customer_id, "
			+ "customer_contract, customer_join, customer_purchase, "
			+ "customer_mileage, customer_level) "
			+ "values(customer_seq.nextval,?,?,?,?,?,?)";
		Object[] data= {customerId,customerContact,customerJoin, 
		customerPurchase,customerMileage,customerLevel};
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		}
	//바람직한 형태의 등록 메소드
	public void insert(CustomerDto dto) {
		String sql="insert into customer(customer_no, customer_id, "
			+ "customer_contact, customer_join, customer_purchase, "
			+ "customer_mileage, customer_level) "
			+ "values(customer_seq.nextval,?,?,?,?,?,?)";
		Object[]data= {dto.getCustomerId(),dto.getCustomerContact(), 
		dto.getCustomerJoin(),dto.getCustomerPurchase(), 
		dto.getCustomerMileage(), dto.getCustomerLevel()};
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
		}
	//U(수정)메소드
	public boolean update(CustomerDto dto) {
		String sql="update customer set customer_id =? , "
				+ "customer_contact =? where customer_no =?";
		Object[]data= {dto.getCustomerId(),dto.getCustomerContact(), 
				dto.getCustomerNo()};
		
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		int result = jdbcTemplate.update(sql,data);
		
		return result>0;
	}
	//D(삭제) 메소드
		//- 삭제 메소드는 Primary key(기본키)를 이용하여 하나씩 지운다
		//- 조건에 따라서 삭제가 안될 수 있기 때문에 결과를 반환해야한다
	public boolean delete(int customerNo) {
		String sql="delete customer where customer_no =?";
		Object[] data= {customerNo};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		int result= jdbcTemplate.update(sql,data);
		
		return result>0;
	}
	
	
	//Mapper 가져오기
	private CustomerMapper mapper =new CustomerMapper();
	
	//R(조회) 메소드
	//- 여러 개의 데이터가 나오는 구문
	// - 자바에서는 List<DTO> 형태로 취급
	// -조회 할려면 Mapper가 필요
	public List<CustomerDto> selectList(){ //고객을 조회하는 메소드 생성
		String sql="select * from customer"; //데이터 베이스 에서 쓰는대로
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate(); //도구 가져오기
		List<CustomerDto>list=jdbcTemplate.query(sql, mapper); //조회는 query씀
		
		return list; //selectList 메소드를 쓰면 list를 반환
	}
	//R(상세) 메소드
	//- Primary ket를 이용하여 하나의 결과만 나오는 구문
	//- 자바에서는 DTO형태로 취급
	//-조회 할려면 Mapper가 필요
	public CustomerDto selectOne(int customerNo) {
		String sql="select * from customer where customer_no =?";
		Object[] data= {customerNo};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		List<CustomerDto>list=jdbcTemplate.query(sql, mapper,data);
		
		return list.isEmpty() ? null : list.get(0); //selectOne 메소드를 쓰면
		//list가 비었을땐 null, 아닐땐 list 0번째 인덱스 반환
	}
	
	public List<CustomerDto> selectListByPage(int page,int size){
		int end=page*size;
		int begin =end-(size-1);
		
		String sql="select * from( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from customer order by customer_id asc"
				+ ")TMP"
				+ ")where rn between ? and ?";
		Object[] data= {begin,end};
		
		JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.query(sql,mapper,data);
	}
	
	
	
	
	
	
}
