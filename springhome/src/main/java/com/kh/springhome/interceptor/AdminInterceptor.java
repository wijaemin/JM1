package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.dao.AdminDao;
import com.kh.springhome.error.AuthorityException;

@Component
public class AdminInterceptor  implements HandlerInterceptor{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		HttpSession session = request.getSession();
		String memberId=(String) session.getAttribute("name");
		
		if(memberId!=null&&
				adminDao.selectOne(memberId).getMemberLevel().equals("관리자")) 
		{
			return true;
		}
		else {
			throw new AuthorityException("접근 권한이 없습니다");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
