package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test18 {
	public static void main(String[] args) {
		
		int page=1;
		int size=5;
		MemberDao dao=new MemberDao();
		List<MemberDto>list=dao.selectListByPage(page,size);
		
		if(list.isEmpty()) {
			System.out.println("표시할 항목이 X");
		}
		else {
			for(MemberDto dto:list) {
				System.out.println("[" + dto.getMemberId() + "]");//list.indexOf(dto)+1 번호 옆에 추가
				System.out.println(dto.getMemberNickname());
				System.out.println(dto.getMemberBirth());
				System.out.println(dto.getMemberEmail());
				System.out.println();
			}
			
		}
		
	}
}
