package jdbc.app;

import jdbc.dao.BoardDao;

public class Test12_1 {
	public static void main(String[] args) {
		int boardNo=3;
		BoardDao dao=new BoardDao();
		boolean result=dao.delete(boardNo);
		
		if(result) System.out.println("게시판 정보 삭제 완료");
		else System.out.println("없는 게시판 번호입니다.");
	}
}
