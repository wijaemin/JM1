package com.wjm.springpractice.interceptor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wjm.springpractice.dao.BoardDao;
import com.wjm.springpractice.dto.BoardDto;
import com.wjm.springpractice.error.NoTargetException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class BoardDefenderInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDto boardDto = boardDao.selectOne(no);
		if(boardDto == null) {
			throw new NoTargetException("존재하지 않는 게시글");
		}
		
		HttpSession session = request.getSession();
		String email= (String) session.getAttribute("email");
		
		Set<Integer> history;
		
		if(session.getAttribute("history")!=null) 
			history =(Set<Integer>) session.getAttribute("history");
		else {
			history= new HashSet<>();
		}
		
		boolean isRead= history.contains(no);
		if(isRead == false) {
			history.add(no);
			session.setAttribute("history", history);
			
		}
		
		boolean isOwner=boardDto.getWriter() !=null
				&& email != null
				&& boardDto.getWriter().equals(email);
		
		if(!isOwner && !isRead) {
			boardDao.updateReadcount(no);
		}
		
		
		return true;
	}
}
