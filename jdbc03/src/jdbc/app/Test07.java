package jdbc.app;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test07 {
	public static void main(String[] args) {
		BoardDto dto =new BoardDto();
		dto.setBoardNo(1);
		dto.setBoardTitle("이게뭐야");
		dto.setBoardContent("이건뭐야");
		
		BoardDao dao = new BoardDao();
		boolean result =dao.update(dto);
		
		if(result) {
			System.out.println("변경완료");
		}
		else {
			System.out.println("존재하지않는 게시판 번호");
		}
	}
}
