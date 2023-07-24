package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.mapper.BookMapper;
import jdbc.util.JdbcUtils;

public class Test04 {
	public static void main(String[] args) {
		String sql="select * from book order by book_id asc";
		
		BookMapper mapper=new BookMapper();//매퍼 가져오기
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate(); //실행도구 가져오기
		
		List<BookDto> list= jdbcTemplate.query(sql, mapper); //리스트 만들기
		
		System.out.println("조회 결과 수 :" +list.size());
		if(list.size()==0) {
			System.out.println("게시글이 존재하지 않습니다");
		}
		else {
			for(BookDto dto:list) {
				System.out.println(dto);
			}
		}
	}
}
