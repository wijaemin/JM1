package com.wjm.springpractice.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.error.AuthorityException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//게시글 소유자인 경우 통과 시키는 인터셉터
//필요한 정보 : 게시글 번호, 사용자 id
@Component
public class BoardOwnerInterceptor implements HandlerInterceptor{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String email=(String) session.getAttribute("email");
		//글 번호를 읽는 코드
		//request.getParameter("이름")으로 파라미터를 읽는다
		//통신이기 때문에 반환형이String이다
		//변환 명령을 사용해서 원하는 형태로 바꿀 수 있다
		int no =Integer.parseInt(request.getParameter("no"));
				
		BoardDto boardDto = boardDao.selectOne(no);		
		
		
		if(boardDto.getWriter().equals(email)) {
			return true;
		}
		else {
			throw new AuthorityException("소유자가 아닙니다");
		}
	}
}
