package com.wjm.springpractice.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.wjm.springpractice.error.AuthorityException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session= request.getSession();
		
		String rank = (String) session.getAttribute("rank");
		
		boolean isAdmin =rank != null && rank.equals("관리자");
		
		
		if(isAdmin) {//관리자라면
			return true;//통과
		}
		else {//아니면
			throw new AuthorityException("권한이 부족합니다");//차단
		}
		
	}
}
