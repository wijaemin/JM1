package jdbc.app;

import java.util.List;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test20 {

	public static void main(String[] args) {
		int boardNo=1;
		
		BoardDao dao =new BoardDao();
		BoardDto dto=dao.slectOne(boardNo);
		List<BoardDto> list=dao.selectList();
		
		if(dao==null) {
			System.out.println("찾는 게시글 목록은 없습니다");
		}
		else {
			System.out.println(dto.getBoardNo());
			System.out.println(dto.getBoardTitle());
			System.out.println(dto.getBoardContent());
			System.out.println(dto.getBoardWriter());
			System.out.println(dto.getBoardContent());
		}

	}

}
