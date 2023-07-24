package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BoardDto;
import jdbc.mapper.BoardMapper;
import jdbc.util.JdbcUtils;

public class Test03_2 {
	public static void main(String[] args) {
		String keyword="이렇게";
		String sql="select * from board "
				+ "where instr(board_title,?)> 0 "
				+ "order by board_no desc";
		Object[] data= {keyword};
		BoardMapper mapper= new BoardMapper();
		
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		
		List<BoardDto> list= jdbcTemplate.query(sql, mapper,data);
		
		if(list.size()==0) {
			System.out.println("게시글이 존재하지 않습니다");
		}
		else {
			for(BoardDto dto:list) {
//				System.out.println(dto);
				System.out.println(dto.getBoardTitle());
			}
		}
	}
}
