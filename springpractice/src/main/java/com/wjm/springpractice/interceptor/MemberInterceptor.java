package com.wjm.springpractice.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class MemberInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		HttpSession session =request.getSession();
		
		String email=(String)session.getAttribute("email");
		boolean isLogin=email !=null;
		
		if(isLogin) {
			return true;
		}
		else {
			//[1]차단 + 로그인 페이지로 리다이렉트
			response.sendRedirect("/member/login");
			//[2]권한 x 오류 발생
//			response.sendError(401);
			return false;
		}

	}
}
