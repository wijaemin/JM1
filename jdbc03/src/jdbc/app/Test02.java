package jdbc.app;

import jdbc.dao.BoardDao;

public class Test02 {
	public static void main(String[] args) {
		String boardTitle="안녕하세용";
		String boardContent="반가워요";
		String boardWriter="user0001";
		int boardReadcount = 102;
		
		BoardDao dao=new BoardDao();
		
//		dao.insert(boardTitle, boardContent, boardWriter, boardReadcount);		
//		System.out.println("등록 완료");
		
		
	}
}
