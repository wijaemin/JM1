package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PocketmonDto;





//Mapper 클래스
//= 데이터베이스 조회결과(ResultSet)를
// 어떻게 PocketmonDto에 넣어야 하는지 알려주기 위한 클래스
public class PocketmonMapper implements RowMapper<PocketmonDto> {

//	@Override
//	public PocketmonDto mapRow(ResultSet arg0, int arg1) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public PocketmonDto mapRow(ResultSet rs, int idx) throws SQLException {
		PocketmonDto dto=new PocketmonDto();
//		dto.setNo(rs의 no 컬럼에 있는 값);
		dto.setNo(rs.getInt("no"));
//		dto.setName(rs의 name 컬럼에 있는 값);
		dto.setName(rs.getString("name"));
//		dto.setType(rs의 type컬럼에 있는 값);
		dto.setType(rs.getString("type"));
		return dto;
	}

	
	//변환 메소드
	//-ResultSet은 데이터베이스에서 조회된 결과물을 의미
	//-idx는 현재 변환중인 회차를 의미
	
	
	
	
	
	
	
	
}
