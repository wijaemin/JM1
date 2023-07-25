package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BoardDto;
import jdbc.mapper.BoardMapper;
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
	public boolean delete(int boardNo) {
		String sql="delete board where board_no =?";
		Object[]data= {boardNo};
		JdbcTemplate jdbcTemplate= JdbcUtils.getJdbcTemplate();
		return jdbcTemplate.update(sql,data)>0;
	}
	
	//(R)게시판 목록
	public BoardMapper mapper= new BoardMapper();
	public List<BoardDto>selectList(){
		String sql="select * from board order by board_no desc";
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		List<BoardDto>list=jdbcTemplate.query(sql, mapper);
		return list;
	}	
	public BoardDto slectOne(int boardNo) {
		String sql="select * from Board where board_no =?";
		Object[] data= {boardNo};
		JdbcTemplate jdbcTemplate =JdbcUtils.getJdbcTemplate();
		List<BoardDto>list=jdbcTemplate.query(sql, mapper,data);
		return list.isEmpty() ? null:list.get(0);
	}
	
	//(심화) 페이지 목록 조회(무조건 10개)
	public List<BoardDto>selectListByPage(int page){
		int end= page* 10;
		int begin =end-9;
		
		String sql="select * from( "
				+ "select rownum rn, TMP.* from( "
				+ "select * from board order by board_no desc"
				+ ")TMP"
				+ ")where rn between ? and ?";
		Object[] data= {begin,end};
		
		JdbcTemplate jdbcTemplate=JdbcUtils.getJdbcTemplate();
		
		return jdbcTemplate.query(sql, mapper,data);
	}
	
	
	
	
	
	
	
	
}
