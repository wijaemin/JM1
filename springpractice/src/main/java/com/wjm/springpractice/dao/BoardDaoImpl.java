package com.wjm.springpractice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.dto.BoardListDto;
import com.wjm.springpractice.mapper.BoardListMapper;
import com.wjm.springpractice.mapper.BoardMapper;
import com.wjm.springpractice.vo.PaginationVO;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardListMapper boardListMapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int sequence() {
		String sql="select board_seq.nextval from dual";
		
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	@Override
	public void insert(BoardDto boardDto) {
		String sql="insert into board(no, writer, title, content, "
				+ "board_group, board_parent, board_depth"
				+ ") values(?, ?, ?, ?, ?, ?, ?)";
		Object[] data= {
				boardDto.getNo(), boardDto.getWriter(), 
				boardDto.getTitle(), boardDto.getContent(),
				boardDto.getBoardGroup(), boardDto.getBoardParent(), 
				boardDto.getBoardDepth()
		};
		jdbcTemplate.update(sql,data);
		
	}
	@Override
	public List<BoardListDto> selectList() {
		//기존 조회 구문
//		String sql="select * from board_list order by no desc";
		
		//계층형 조회 구문
		String sql ="select * from board_list "
				+ "connect by prior no = board_parent "
				+ "start with board_parent is null "
				+ "order siblings by board_group desc, no asc";
		
		
		return jdbcTemplate.query(sql, boardListMapper);
	}
	@Override
	public BoardDto selectOne(int no) {
		String sql="select * from board where no=?";
		Object[] data= {no};
		
		List<BoardDto> list=jdbcTemplate.query(sql, boardMapper,data);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean edit(BoardDto boardDto) {
		String sql="update board set title=?, content=?, updated_at=sysdate where no=?";
		Object[] data= {
				boardDto.getTitle(), boardDto.getContent(), boardDto.getNo()
		};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean delete(int no) {
		String sql="delete board where no=?";
		Object[] data= {no};
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean updateReadcount(int no) {
		String sql="update board set readcount=readcount+1 where no=?";
		Object[] data = {no};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	
	@Override
	public Integer selectMaxNo(String writer) {
		String sql="select max(no) from board where writer=?";
		Object[] data= {writer};
		
		return jdbcTemplate.queryForObject(sql, Integer.class, data);
	}
	
	@Override
	public List<BoardListDto> selectList(String type, String keyword) {
		
		String sql="select * from board_list "
				+ "where instr(" + type + ",?) >0 "
				+ "connect by prior no = board_parent "
				+ "start with board_parent is null "
				+ "order siblings by board_group desc, no asc";
		Object[] data= {keyword};
		
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
//	@Override
//	public List<BoardListDto> selectListByPage(int page) {
//		
//		int begin = page*10 -9;
//		int end = page*10;
//		String sql="select * from ("
//				+ "select rownum rn, TMP.* from("
//				+ "select * from board_list "
//				+ "connect by prior no = board_parent "
//				+ "start with board_parent is null "
//				+ "order siblings by board_group desc, no asc"
//				+ ")TMP"
//				+ ") where rn between ? and ?";
//		Object[] data= {begin, end};
//		return jdbcTemplate.query(sql,boardListMapper ,data);
//	}
//	
//	@Override
//	public List<BoardListDto> selectListByPage(String type, String keyword, int page) {
//		int begin=page*10-9;
//		int end=page*10;
//		String sql="select * from ("
//				+ "select rownum rn, TMP.* from("
//				+ "select * from board_list "
//				+ "where instr(" + type + ",?) >0 "
//				+ "connect by prior no = board_parent "
//				+ "start with board_parent is null "
//				+ "order siblings by board_group desc, no asc"
//				+ ")TMP"
//				+ ") where rn between ? and ?";
//		Object[] data= {keyword, begin, end};
//		return jdbcTemplate.query(sql, boardListMapper, data);
//	}
	
	
	
	@Override
	public List<BoardListDto> selectListByPage(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from board_list "
					+ "where instr(" + vo.getType() + ",?) >0 "
					+ "connect by prior no = board_parent "
					+ "start with board_parent is null "
					+ "order siblings by board_group desc, no asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data= {vo.getKeyword(), vo.getStartRow(), vo.getFinishRow()};
			
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
		else {
			String sql="select * from ("
					+ "select rownum rn, TMP.* from("
					+ "select * from board_list "
					+ "connect by prior no = board_parent "
					+ "start with board_parent is null "
					+ "order siblings by board_group desc, no asc"
					+ ")TMP"
					+ ") where rn between ? and ?";
			Object[] data= {vo.getStartRow(),vo.getFinishRow()};			
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
	}

	@Override
	public int countList() {
		String sql="select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	@Override
	public int countList(String type, String keyword) {
		String sql="select count(*) from board "
				+ "where instr(" + type + ",?) >0 ";
		Object[] data= {keyword};
		return jdbcTemplate.queryForObject(sql,int.class, data);
	}

	@Override
	public int countList(PaginationVO vo) {
		if(vo.isSearch()) {
			String sql="select count(*) from board "
					+ "where instr(" + vo.getType() + ",?) >0 ";
			Object[] data= {vo.getKeyword()};
			return jdbcTemplate.queryForObject(sql,int.class, data);
		}
		else {
			String sql="select count(*) from board";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
	@Override
	public List<BoardListDto> selectListByWriter(String writer) {
		String sql="select * from ("
				+ "select rownum rn, TMP.* from("
				+"select * from board_list "
				+ "where writer=?"
				+ "order by no desc"
				+ ")TMP"
				+ ") where rn between 1 and 5";
		
		Object[] data= {writer};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	@Override
	public boolean updateBoardReplycount(int no) {
		String sql="update board set replycount=("
				+ " select count(*) from reply where origin=?"
				+ ") "
				+ "where no=?";
		Object[] data= {no,no};
		
		return jdbcTemplate.update(sql,data)>0;
	}
	@Override
	public boolean updateBoardLikecount(int no, int count) {
		String sql="update board set likecount=? where no=?";
		Object[] data= {count, no};
		return jdbcTemplate.update(sql,data)>0;
	}
	}
