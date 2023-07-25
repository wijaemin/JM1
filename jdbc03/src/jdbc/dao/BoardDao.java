package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BoardDto;
import jdbc.util.JdbcUtils;

public class BoardDao {
	
//	public void insert(String boardTitle, String boardContent, 
//			String boardWriter, int boardReadcount) {
//		String sql="insert into board(board_no, board_title, board_content, "
//				+ "board_writer, board_readcount) "
//				+ "values(board_seq.nextval,?, ?, ?, ?)";
//		Object[] data= {boardTitle,boardContent,boardWriter,boardReadcount};
//		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
//		jdbcTemplate.update(sql,data);
//	}
	public void insert(String boardTitle, String boardContent, 
			String boardWriter) {
		String sql="insert into board(board_no, board_title, board_content, "
				+ "board_writer)"
				+ "values(board_seq.nextval,?, ?, ?)";
		Object[] data= {boardTitle,boardContent,boardWriter};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
	}
	public void insert(BoardDto dto) {
		String sql = "insert into board("
				+ "board_no, board_title, board_content, "
				+ "board_writer, board_readcount"
			+ ") values(board_seq.nextval, ?, ?, ?, 0)";
		Object[] data = { 
				dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardWriter()
		};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		jdbcTemplate.update(sql,data);
	}
	public boolean update(BoardDto dto) {
		String sql="update board set board_title=?, board_content=? where board_no=?";
		Object[] data = {
		dto.getBoardTitle(),dto.getBoardContent(),dto.getBoardNo()};
		
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		int result=jdbcTemplate.update(sql,data);
		
		return result>0;
		
	}
	
	
}
