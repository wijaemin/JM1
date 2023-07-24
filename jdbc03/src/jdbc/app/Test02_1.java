package jdbc.app;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test02_1 {
	public static void main(String[] args) {
//		String boardTitle="안녕하세용";
//		String boardContent="반가워요";
//		String boardWriter="user12345";

		BoardDto dto =new BoardDto();
		dto.setBoardTitle("테스트제목");
		dto.setBoardContent("테스트내용2");
		dto.setBoardWriter("testwriter2");
		
		BoardDao dao=new BoardDao();
		
//		dao.insert(boardTitle, boardContent, boardWriter);
		dao.insert(dto);
		System.out.println("등록 완료");
	}
}
