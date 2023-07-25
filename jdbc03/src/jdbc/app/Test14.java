package jdbc.app;

import java.util.List;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test14 {
	public static void main(String[] args) {
		//포켓몬스터 번호를 이용하여 상세 조회
		
		//데이터
		int no =999;
		
		//처리
		PocketmonDao dao=new PocketmonDao();
		PocketmonDto dto=dao.selectOne(no);
		List<PocketmonDto>list=dao.selectList();
		//출력
		if(dto==null) {
			System.out.println("찾으시는 번호의 몬스터는 없어요");
		}
		else {
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getType());
		}
	}
}
